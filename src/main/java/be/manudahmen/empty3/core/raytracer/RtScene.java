/*
 * Copyright (c) 2017. Tous les fichiers dans ce programme sont soumis à la License Publique Générale GNU créée par la Free Softxware Association, Boston.
 * La plupart des licenses de parties tièrces sont compatibles avec la license principale.
 * Les parties tierces peuvent être soumises à d'autres licenses.
 * Montemedia : Creative Commons
 * ECT : Tests à valeur artistique ou technique.
 * La partie RayTacer a été honteusement copiée sur le Net. Puis traduite en Java et améliorée.
 * Java est une marque de la société Oracle.
 *
 * Pour le moment le programme est entièrement accessible sans frais supplémentaire. Get the sources, build it, use it, like it, share it.
 */

package be.manudahmen.empty3.core.raytracer;

import be.manudahmen.empty3.Representable;

import java.util.ArrayList;
import java.util.List;

public class RtScene {

    private int mNumNodes;
    private List<RtNode> mNodes = new ArrayList<RtNode>();
    private List<Representable> mNodesR = new ArrayList<Representable>();
    private List<RtCamera> mCameras = new ArrayList<RtCamera>();
    private List<RtLight> mLights = new ArrayList<RtLight>();
    private List<RtMatiere> mMaterials = new ArrayList<RtMatiere>();
    private RtCamera mActiveCamera;


    // constructeurs et destructeurs
    public RtScene() {
        mNumNodes = 0;
        mActiveCamera = null;


    }

    // get
    public int getNumNodes() {
        return mNodes.size();
    }

    public RtNode getNode(int i) {
        assert (i < mNodes.size());
        return mNodes.get(i);
    }

    public RtLight getLight(int i) {
        assert (i < mLights.size());
        return mLights.get(i);
    }

    public int getNumLights() {
        return mLights.size();
    }

    public RtCamera getActiveCamera() {
        return mActiveCamera;
    }

    public void setActiveCamera(RtCamera cam) {
        assert (cam != null);
        mActiveCamera = cam;
    }

    // set
    public void setActiveCamera(int i) {
        assert (i < mCameras.size());
        mActiveCamera = mCameras.get(i);
    }

    public RtMatiere getMaterial(int i) {
        assert (i < mMaterials.size());
        return mMaterials.get(i);
    }

    // methodes
    public boolean addObject(RtObject object) {
        assert (object != null);
        addNode(object);
        return true;
    }

    public boolean addCamera(RtCamera camera) {
        assert (camera != null);
        mCameras.add(camera);
        addNode(camera);
        setActiveCamera(camera);
        return true;
    }

    public boolean addNode(RtNode node) {
        assert (node != null);
        mNodes.add(node);
        mNumNodes++;
        return true;
    }

    public boolean addLight(RtLight light) {
        assert (light != null);
        mLights.add(light);
        addNode(light);
        return true;
    }

    public boolean addMaterial(RtMatiere material) {
        assert (material != null);
        mMaterials.add(material);
        return true;
    }

    public void addObject(Representable myCube) {
        mNodesR.add(new Representable());
    }

    public List<Representable> getRepresentables() {
        return mNodesR;
    }
}
