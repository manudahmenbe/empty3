package info.emptycanvas.library.raytracer;

import info.emptycanvas.library.object.ECBufferedImage;
import info.emptycanvas.library.object.Point3D;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class Raytracer {

    /* [ Coeur du raytracer. L'algo du raytracing se trouve dans cette fonction, dont le r�le est de calculer ] */
/* [ la couleur finale du pixel courant, en lui passant le rayon primaire �mis.                           ] */
    public static Color rayTrace(CScene scene, CRay ray, int depth) {
        Color finalColor = new Color(0.0f, 0.0f, 0.0f);    // La couleur finale (noire au debut ... couleur de fond)
        double distance = 999999.9f;            // La distance parcourue par le rayon avant de toucher la node
        double tmpDistance;                    // Une distance temporaire
        CNode currentNode;
        // La node en cours de traitement
        CNode closestNode = null;                // La node qui sera la plus proche
        CIntersectInfo interInfo = new CIntersectInfo();                        // Les informations sur l'intersection
        CIntersectInfo closestInterInfo = new CIntersectInfo();                // Les informations sur l'intersection de la node la plus proche


        // Eclairage
        boolean lightBlocked;        // Booleen qui nous permet de dire si le rayon de lumi�re est bloqu� sur son chemin ou non
        Point3D lightVec;            // Le vecteur allant de la source lumineuse vers le point d'intersection
        double lightToObjDist;        // La distance entre la source lumineuse et le point d'intersection
        double lightToInterDist;    // La distance entre la source lumineuse et le point d'intersection de la node courante
        CRay lightRay = new CRay();            // Le rayon lumineux
        CIntersectInfo lightInterInfo = new CIntersectInfo();        // Les informations sur l'intersection du rayon lumineux et d'une node


        // On parcoure toutes les nodes de notre scene (cameras, objets ...)
        for (int i = 0; i < scene.getNumNodes(); i++) {
            currentNode = scene.getNode(i);

            if (currentNode.intersectsNode(ray, interInfo)) {
                // On n'a pas besoin de comparer la longueur en elle meme (qui est la racine carr� de la somme des carr�s des coeeficients)
                // En evitant la racine carr� on obtient la meme comparaison, mais en une op�ration de moins (sqrt est tr�s gourmand).
                tmpDistance = (interInfo.mIntersection.moins(ray.mVStart)).norme();

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
                lightBlocked = false;

                // Calc the vec (normalized) going from the light to the intersection point
                lightVec = closestInterInfo.mIntersection.
                        moins(scene.getLight(i).getPosition());
                lightToObjDist = lightVec.norme();//??getMagnitude();
                lightVec = lightVec.norme1();

                lightRay.mVStart = scene.getLight(i).getPosition();
                lightRay.mVDir = lightVec;

                // We go through all the objects to see if one
                // of them block the light coming to the dest object
                for (int j = 0; j < scene.getNumNodes(); j++) {
                    currentNode = scene.getNode(j);

                    // put away the case of the object itself
                    if (currentNode != closestInterInfo.mNode)
                        if (currentNode.intersectsNode(lightRay, lightInterInfo)) {
                            lightToInterDist = (lightInterInfo.mIntersection.moins(scene.getLight(i).getPosition()).norme());///magnitude
                            if (lightToInterDist < lightToObjDist)
                                lightBlocked = true;
                        }
                }

                if (!lightBlocked)
                    finalColor = CColor.add(finalColor, scene.getLight(i).getLightAt(closestInterInfo.mNormal, closestInterInfo.mIntersection, closestInterInfo.mMaterial));
            }

            // Clean non permanent material
        /*if (closestInterInfo.mMaterial.GetPermanency() == false)
			delete (closestInterInfo.mMaterial); closestInterInfo.mMaterial = NULL;
			*/
        }


        return finalColor = CColor.normalizeColor(finalColor);
    }

    /* [ Fonction de rendu. Parcoure tous les pixels de l'image, cr�e le rayon correpondant et lance le raytracing ] */
/* [ avec ce rayon. Enregistre le rendu final dans un fichier image.                                           ] */
    public static boolean Render(CScene scene, int width, int height, String outputfilename) throws IOException {
        CRay currentRay = new CRay();            // Le rayon primaire �mis courant (de l'oeil, � travers un pixel, vers la sc�ne).
        Point3D vDir;                // Le vecteur directeur (unitaire) du rayon.
        PrintWriter mOutputFileRAW;    // Le fichier image destination (format RAW : rvbrvbrvbrvb....).
        Color tmpColor;            // La couleur finale du pixel courant.
        byte tmpR, tmpG, tmpB;    // Les trois composantes de la couleur (Rouge Vert Bleu).
        ECBufferedImage bi2 = new ECBufferedImage(width, height,
                ECBufferedImage.TYPE_INT_RGB);

        // On cree le fichier destination
        mOutputFileRAW = new PrintWriter(new FileOutputStream(new File(outputfilename + ".pbm")));
        mOutputFileRAW.println("P4");
        mOutputFileRAW.println(width);
        mOutputFileRAW.println(height);
        //mOutputFileRAW.write(""+256);
        // On parcoure tous les pixels de l'image finale
        for (int y = 0; y < height; y++)
            for (int x = 0; x < width; x++) {
                // [---Creation du rayon � emetrre---]
                // L'origine du rayon est la position de la camera
                currentRay.mVStart = scene.getActiveCamera().getPosition();

                // On calcule le veteur directeur gr�ce � une m�thode de la classe CCamera
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
                tmpR = (byte) (tmpColor.getRed() * 255);
                tmpG = (byte) (tmpColor.getGreen() * 255);
                tmpB = (byte) (tmpColor.getBlue() * 255);
                int elementCouleur = (tmpR << 16) | (tmpG << 8) | (tmpB);
                bi2.setRGB(x, y, elementCouleur);

                // Et on ecrit finalement la couleur de ce pixel dans le fichier
                mOutputFileRAW.println(tmpR + " " + " " + tmpG + " " + tmpB + "\n");
            }

        System.out.print("+raw");
        mOutputFileRAW.flush();
        mOutputFileRAW.close();

        System.out.print("+jpg");
        ImageIO.write(bi2, "jpg", new File(outputfilename + ".jpg"));

        return true;
    }


}