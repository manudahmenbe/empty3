package be.manudahmen.emptycanvas.library.empty3.library.raytracer;

import be.manudahmen.emptycanvas.library.empty3.library.object.ECBufferedImage;
import be.manudahmen.emptycanvas.library.empty3.library.object.Point3D;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class RtRaytracer {


    /* [ Coeur du raytracer. L'algo du raytracing se trouve dans cette fonction, dont le r�le est de calculer ] */
/* [ la couleur finale du pixel courant, en lui passant le rayon primaire �mis.                           ] */
    public static RtColor rayTrace(RtScene scene, RtRay ray, int depth) {
        RtColor finalColor = new RtColor(0.0f, 0.0f, 0.0f);    // La couleur finale (noire au debut ... couleur de fond)
        double distance = 999999.9f;            // La distance parcourue par le rayon avant de toucher la node
        double tmpDistance;                    // Une distance temporaire
        RtNode currentNode;
        // La node en cours de traitement
        RtNode closestNode = null;                // La node qui sera la plus proche
        RtIntersectInfo interInfo;                        // Les informations sur l'intersection
        RtIntersectInfo closestInterInfo = null;                // Les informations sur l'intersection de la node la plus proche


        // Eclairage
        boolean lightBlocked;        // Booleen qui nous permet de dire si le rayon de lumi�re est bloqu� sur son chemin ou non
        Point3D lightVec;            // Le vecteur allant de la source lumineuse vers le point d'intersection
        double lightToObjDist;        // La distance entre la source lumineuse et le point d'intersection
        double lightToInterDist;    // La distance entre la source lumineuse et le point d'intersection de la node courante
        RtRay lightRay = new RtRay();            // Le rayon lumineux
        RtIntersectInfo lightInterInfo = new RtIntersectInfo();        // Les informations sur l'intersection du rayon lumineux et d'une node

        interInfo = new RtIntersectInfo();                        // Les informations sur l'intersection
        // On parcoure toutes les nodes de notre scene (cameras, objets ...)
        for (int i = 0; i < scene.getNumNodes(); i++) {
            currentNode = scene.getNode(i);

            if (currentNode.intersectsNode(ray, interInfo)) {
                // On n'a pas besoin de comparer la longueur en elle meme (qui est la racine carr� de la somme des carr�s des coeeficients)
                // En evitant la racine carr� on obtient la meme comparaison, mais en une op�ration de moins (sqrt est tr�s gourmand).
                tmpDistance = interInfo.mIntersection.moins(ray.mVStart).norme();

                if (tmpDistance < distance) {
                    distance = tmpDistance;
                    closestNode = currentNode;
                    closestInterInfo = interInfo;
                }
            }
        }

        if (closestNode != null) {
            // On parcoure toute les sources lumineuses
            for (int i = 0; i < scene.getNumLights(); i++) {
                RtLight currentLight = scene.getLight(i);


                lightBlocked = false;

                // Calc the vec (normalized) going from the light to the intersection point
                lightVec = closestInterInfo.mIntersection.
                        moins(currentLight.getPosition());
                lightToObjDist = lightVec.norme();//??getMagnitude();
                lightVec = lightVec.norme1();

                lightRay.mVStart = currentLight.getPosition();
                lightRay.mVDir = lightVec;

                // We go through all the objects to see if one
                // of them block the light coming to the dest object
                for (int j = 0; j < scene.getNumNodes(); j++) {
                    currentNode = scene.getNode(j);

                    // put away the case of the object itself
                    if (closestNode != closestInterInfo.mNode)
                        if (currentNode.intersectsNode(lightRay, lightInterInfo)) {
                            lightToInterDist = (lightInterInfo.mIntersection.moins(lightRay.mVStart).norme());///magnitude
                            if (lightToInterDist < lightToObjDist)
                                lightBlocked = true;

                        }
                }
                if (!lightBlocked)
                    finalColor = RtColor.add(finalColor, currentLight.getLightAt(closestInterInfo.mNormal, closestInterInfo.mIntersection, closestInterInfo.mMaterial));
                else
                    finalColor = RtColor.add(finalColor, new RtColor(0f, 0f, 0f, 0f));

            }
            // Clean non permanent material
        /*if (closestInterInfo.mMaterial.GetPermanency() == false)
            delete (closestInterInfo.mMaterial); closestInterInfo.mMaterial = NULL;
			*/
        }


        return finalColor = RtColor.normalizeColor(finalColor);
    }


    /* [ Fonction de rendu. Parcoure tous les pixels de l'image, cr�e le rayon correpondant et lance le raytracing ] */
/* [ avec ce rayon. Enregistre le rendu final dans un fichier image.                                           ] */
    public static boolean Render(RtScene scene, int width, int height, String outputfilename) throws IOException {
        RtRay currentRay = new RtRay();            // Le rayon primaire �mis courant (de l'oeil, � travers un pixel, vers la sc�ne).
        Point3D vDir;                // Le vecteur directeur (unitaire) du rayon.
        PrintWriter mOutputFileRAW;    // Le fichier image destination (format RAW : rvbrvbrvbrvb....).
        RtColor tmpColor;            // La couleur finale du pixel courant.
        int tmpR;    // Les trois composantes de la couleur (Rouge Vert Bleu).
        int tmpG;
        int tmpB;
        int tmpA = 255;
        ECBufferedImage bi2 = new ECBufferedImage(width, height,
                ECBufferedImage.TYPE_INT_RGB);

        // On cree le fichier destination
        mOutputFileRAW = new PrintWriter(new FileOutputStream(new File(outputfilename + ".ppm")));
        mOutputFileRAW.println("P3");
        mOutputFileRAW.println("# Image genereted with Empty3 http://gitlab/Graphics3D/Empty3");
        mOutputFileRAW.println("" + width);
        mOutputFileRAW.println("" + height);
        mOutputFileRAW.println("" + 256);
        // On parcoure tous les pixels de l'image finale
        for (int y = 0; y < height; y++)
            for (int x = 0; x < width; x++) {
                // [---Creation du rayon � emetrre---]
                // L'origine du rayon est la position de la camera
                currentRay.mVStart = scene.getActiveCamera().getPosition();

                // On calcule le veteur directeur gr�ce � une m�thode de la classe RtCamera
                vDir = scene.getActiveCamera().calcDirVec(x, y, width, height);
                vDir.normalize();
                currentRay.mVDir = vDir;

                // On trace le rayon, et on recup�re la couleur finale du pixel
                tmpColor = rayTrace(scene, currentRay, 0);

                // Affichage de notre "barre de progression" ;)
                if (x == 0 && y == 0.25f * height)
                    System.out.printf("25 percent completed !\n");

                if (x == 0 && y == 0.5f * height)
                    System.out.printf("50 percent completed !\n");

                if (x == 0 && y == 0.75f * height)
                    System.out.printf("75 percent completed !\n");

                if (x == 0 && y == height - 1)
                    System.out.printf("100 percent completed !\n");

                // On decompose la couleur dans les trois couleurs de base (Rouge Vert Bleu).
                RtColor fc = RtColor.normalizeColor(tmpColor);
                tmpR = (int) (tmpColor.getRed() * 256);
                tmpG = (int) (tmpColor.getGreen() * 256);
                tmpB = (int) (tmpColor.getBlue() * 256);
                tmpA = (int) (tmpColor.getAlpha() * 256);
                int elementCouleur = (tmpA << 0) | (tmpR << 24) | (tmpG << 16) | (tmpB << 8);
                bi2.setRGB(x, y, elementCouleur);

                // Et on ecrit finalement la couleur de ce pixel dans le fichier
                mOutputFileRAW.println(tmpR + " " + " " + tmpG + " " + tmpB + "\n");
            }

        System.out.print("+ppm");
        mOutputFileRAW.flush();
        mOutputFileRAW.close();

        System.out.print("+jpg");
        ImageIO.write(bi2, "jpg", new File(outputfilename + ".jpg"));

        return true;
    }


}