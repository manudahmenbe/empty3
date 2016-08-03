#include "RayTracerChap2.h"
#include <assert.h>

int main()
{
	// Notre sc�ne
	CScene			myScene;

	// Notre cam�ra
	CTargetCamera*	myCamera=NULL;						
	Point3D		myCameraPos(0.0f, 3.0f, -15.0f);	// Position de la camera
	Point3D		myCameraLookAt(0.0f, 0.0f, 10.0f);	// Position du point regard�
	Point3D		myCameraUpVec(0.0f, 1.0f, 0.0f);	// Vecteur haut de la cam�ra

	// Une sph�re
	CSphere*		mySphere=NULL;
	Point3D		mySpherePos(0.0f, 0.0f, 10.0f);		// Position de la sph�re
	float			mySphereRadius = 2.0f;				// Rayon de la sph�re

	// Un plan
	CPlane*			myPlane=NULL;
	Point3D		myPlanePos(0.0f, -2.0f, 0.0f);
	Point3D		myPlaneNormal(0.0f, 1.0f, 0.0f);

	// Une premi�re lumi�re (rouge)
	CPointLight*	myLight;
	Point3D		myLightPos(3.0f, 3.0f, 0.0f);
	float			myLightDiffuseColor = 1.0f;
	float			myLightSpecularColor = 1.0f;
	CColor			myLightColor(1.0f, 0.0f, 0.0f);

	// Une deuxi�me lumi�re (bleue)
	CPointLight*	myLight1;
	Point3D		myLight1Pos(-3.0f, 3.0f, 0.0f);
	float			myLight1DiffuseColor = 1.0f;
	float			myLight1SpecularColor = 1.0f;
	CColor			myLight1Color(0.0f, 0.0f, 1.0f);

	// Deux materiaux
	CMaterial*		myMaterial;
	CMaterial*		myMaterial1;
	

	myCamera	= new CTargetCamera(myCameraPos, myCameraLookAt, myCameraUpVec); assert (myCamera != NULL);
	mySphere	= new CSphere(mySpherePos, mySphereRadius); assert (mySphere != NULL);
	myPlane		= new CPlane(myPlanePos, myPlaneNormal);
	myLight		= new CPointLight(myLightPos, myLightDiffuseColor, myLightSpecularColor, myLightColor);
	myLight1	= new CPointLight(myLight1Pos, myLight1DiffuseColor, myLight1SpecularColor, myLight1Color);
	myMaterial	= new CMaterial("myMaterial", CColor(0.0f, 0.0f, 0.0f), CColor(1.0f, 1.0f, 1.0f), CColor(0.0f, 0.0f, 0.0f), CColor(0.0f, 0.0f, 0.0f), 0.0f, 0.0f);
	myMaterial1 = new CMaterial("myMaterial1", CColor(0.0f, 0.0f, 0.0f), CColor(0.7f, 0.7f, 0.7f), CColor(0.0f, 0.0f, 0.0f), CColor(0.0f, 0.0f, 0.0f), 0.0f, 0.0f);

	// On assigne les materiaux � nos objets
	mySphere->SetMaterial(myMaterial);
	myPlane->SetMaterial(myMaterial1);

	// On ajoute les �l�ments � notre sc�ne
	myScene.AddCamera(myCamera);
	myScene.AddObject(mySphere);
	myScene.AddObject(myPlane);
	myScene.AddLight(myLight);
	myScene.AddLight(myLight1);
	myScene.AddMaterial(myMaterial);

	// On lance le rendu
	Render(myScene, 640, 480, "renders//Chapitre2.raw");

	// On lib�re la m�moire avant de quitter
	SAFERELEASE(myCamera);
	SAFERELEASE(mySphere);
	SAFERELEASE(myPlane);
	SAFERELEASE(myLight);
	SAFERELEASE(myLight1);
	SAFERELEASE(myMaterial);
	SAFERELEASE(myMaterial1);

	return 0;
}

