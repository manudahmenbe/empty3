package info.emptycanvas.library.raytracer;

import java.util.List;

public class CScene {

    private int mNumNodes;
    private List<CNode> mNodes;
    private List<CCamera> mCameras;
    private List<CLight> mLights;
    private List<Matiere> mMaterials;
    private CCamera mActiveCamera;


    // constructeurs et destructeurs
    public CScene() {
        mNumNodes = 0;
        mActiveCamera = null;
    }

    // get
    public int getNumNodes() {
        return mNumNodes;
    }

    public CNode getNode(int i) {
        assert (i < mNodes.size());
        return mNodes.get(i);
    }

    public CLight getLight(int i) {
        assert (i < mLights.size());
        return mLights.get(i);
    }

    public int getNumLights() {
        return mLights.size();
    }

    public CCamera getActiveCamera() {
        return mActiveCamera;
    }

    public void setActiveCamera(CCamera cam) {
        assert (cam != null);
        mActiveCamera = cam;
    }

    public Matiere getMaterial(int i) {
        assert (i < mMaterials.size());
        return mMaterials.get(i);
    }

    // set
    public void setActiveCamera(int i) {
        assert (i < mCameras.size());
        mActiveCamera = mCameras.get(i);
    }

    // methodes
    public boolean addObject(CObject object) {
        assert (object != null);
        addNode(object);
        return true;
    }

    public boolean addCamera(CCamera camera) {
        assert (camera != null);
        mCameras.add(camera);
        addNode(camera);
        setActiveCamera(camera);
        return true;
    }

    public boolean addNode(CNode node) {
        assert (node != null);
        mNodes.add(node);
        mNumNodes++;
        return true;
    }

    public boolean addLight(CLight light) {
        assert (light != null);
        mLights.add(light);
        addNode(light);
        return true;
    }

    public boolean addMaterial(Matiere material) {
        assert (material != null);
        mMaterials.add(material);
        return true;
    }
}
