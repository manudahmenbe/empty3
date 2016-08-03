package info.emptycanvas.library.object;

import java.awt.*;

/**
 * Created by manuel on 30-07-16.
 */
public class Matiere {/*! \class CMaterial
 *  \brief Cette classe repr�sente les materiaux ainsi que les o�prations de base sur ces derniers.
 *  \author Beno�t Lemaire (aka DaRkWoLf)
 *  \date   19/04/2002
 */

    private String mName;
    private Color mSpecularColor;
    private Color mDiffuseColor;
    private Color mAmbientColor;
    private Color mSelfIllumColor;
    private float mShininess;
    private float mShinestrength;
    private float mTransmittivity;
    private float mReflectivity;
    private boolean mPermanent;


    // constructor and destructor
    public Matiere() {
        mName = "EMPTY MAT";
        mSpecularColor = new Color(0.0f, 0.0f, 0.0f);
        mDiffuseColor = new Color(0.0f, 0.0f, 0.0f);
        mAmbientColor = new Color(0.0f, 0.0f, 0.0f);
        mSelfIllumColor = new Color(0.0f, 0.0f, 0.0f);
        mShininess = 0.0f;
        mShinestrength = 0.0f;
        mTransmittivity = 0.0f;
        mReflectivity = 0.0f;
        mPermanent = true;
    }

    public Matiere(String name, Color specular, Color diffuse, Color ambient, Color selfillum, float transmittivity, float reflectivity, float shininess, float shinestrength, boolean permanent) {
        mName = name;
        mSpecularColor = specular;
        mDiffuseColor = diffuse;
        mAmbientColor = ambient;
        mSelfIllumColor = selfillum;
        mShininess = shininess;

        mShinestrength = shinestrength;
        mTransmittivity = transmittivity;
        mReflectivity = reflectivity;
        mPermanent = permanent;
    }

    // get
    public String GetName() {
        return mName;
    }

    public Color GetDiffuse() {
        return mDiffuseColor;
    }

    public Color GetSpecular() {
        return mSpecularColor;
    }

    public Color GetAmbient() {
        return mAmbientColor;
    }

    public Color GetSelfIllum() {
        return mSelfIllumColor;
    }

    public float GetShininess() {
        return mShininess;
    }

    public float GetShinestStrength() {
        return mShinestrength;
    }

    public float GetTransmittivity() {
        return mTransmittivity;
    }

    public float GetReflectivity() {
        return mReflectivity;
    }

    public boolean GetPermanency() {
        return mPermanent;
    }

    // set
    public void SetName(String name) {
        mName = name;
    }

    public void SetSpecular(Color specular) {
        mSpecularColor = specular;
    }

    public void SetDiffuse(Color diffuse) {
        mDiffuseColor = diffuse;
    }

    public void SetAmbient(Color ambient) {
        mAmbientColor = ambient;
    }

    public void SetSelfIllum(Color selfIllum) {
        mSelfIllumColor = selfIllum;
    }

    public void SetShininess(float shininess) {
        mShininess = shininess;
    }

    public void SetShinesStrenght(float sStrength) {
        mShinestrength = sStrength;
    }

    public void SetTransparency(float transmittivity) {
        mTransmittivity = transmittivity;
    }

    public void SetReflectivity(float reflectivity) {
        mReflectivity = reflectivity;
    }

    public void SetPermanency(boolean permanent) {
        mPermanent = permanent;
    }
/*
        // operators
         public static Matiere mult(Matiere mat, float multiple)
        { return Matiere( "COMPOSITE MATERIAL",
                mat.mSpecularColor*multiple,
                mat.mDiffuseColor*multiple,
                mat.mAmbientColor*multiple,
                mat.mSelfIllumColor*multiple,
                mat.mTransmittivity*multiple,
                mat.mReflectivity*multiple,
                mat.mShininess*multiple,
                mat.mShinestrength*multiple ); }

         friend CMaterial operator+ (const CMaterial& mat1, const CMaterial& mat2)
        { return CMaterial( "COMPOSITE MATERIAL",
                mat1.mSpecularColor+mat2.mSpecularColor,
                mat1.mDiffuseColor+mat2.mDiffuseColor,
                mat1.mAmbientColor+mat2.mAmbientColor,
                mat1.mSelfIllumColor+mat2.mSelfIllumColor,
                mat1.mTransmittivity+mat2.mTransmittivity,
                mat1.mReflectivity+mat2.mReflectivity,
                mat1.mShininess+mat2.mShininess,
                mat1.mShinestrength+mat2.mShinestrength ); }

         friend void operator+= (CMaterial& mat1, const CMaterial& mat2)
        {	mat1.mName = "COMPOSITE MATERIAL";
            mat1.mSpecularColor += mat2.mSpecularColor;
            mat1.mDiffuseColor += mat2.mDiffuseColor;
            mat1.mAmbientColor += mat2.mAmbientColor;
            mat1.mSelfIllumColor += mat2.mSelfIllumColor;
            mat1.mTransmittivity += mat2.mTransmittivity;
            mat1.mReflectivity += mat2.mReflectivity;
            mat1.mShininess += mat2.mShininess;
            mat1.mShinestrength += mat2.mShinestrength;
        }

        // misc functions
         CMaterial InterpolateMaterials(const CMaterial& mat1, const CMaterial& mat2) const
        { return CMaterial(	"COMPOSITE MATERIAL",
                (mat1.mSpecularColor+mat2.mSpecularColor)/2.0f,
                (mat1.mDiffuseColor+mat2.mDiffuseColor)/2.0f,
                (mat1.mAmbientColor+mat2.mAmbientColor)/2.0f,
                (mat1.mSelfIllumColor+mat2.mSelfIllumColor)/2.0f,
                (mat1.mTransmittivity+mat2.mTransmittivity)/2.0f,
                (mat1.mReflectivity+mat2.mReflectivity)/2.0f,
                (mat1.mShininess+mat2.mShininess)/2.0f,
                (mat1.mShinestrength+mat2.mShinestrength)/2.0f	); }
    };

*/
}
