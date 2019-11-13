/*
 *  This file is part of Empty3.
 *
 *     Empty3 is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Empty3 is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Empty3.  If not, see <https://www.gnu.org/licenses/>. 2
 */

package one.empty3.library;

/**
 * Created by manue on 06-11-19.
 */
public class ArcBall2 {
    private float ballRadius;
    private boolean isRotating;
    private int width;
    private int height;
    private Point3D startRotationVector;
    private Point3D currentRotationVector;

    /**
 * \ingroup GLVisualization
 * Default constructor, it sets the ballRadius to 600
 **//*
    public ArcBall2()
    {  this.ballRadius=600;
        isRotating=false;
        width=height=0;
        reset();
    }

    /**
     * \ingroup GLVisualization
     * Set width and height of the current windows, it's needed every time you resize the window
     * \param w Width of the rendering window
     * \param h Height of the rendering window
     **//*
    void setWidthHeight(int w, int h)
    {  width=w;
        height=h;
        ballRadius = Math.min((int)(w/2), (int)(h/2));
    }

    /**
     * \ingroup GLVisualization
     * Set the radius of the ball (a typical radius for a 1024x768 window is 600
     * \param newRadius The radius of the spherical dragging area
     **//*
    void setRadius(float newRadius)
    {  ballRadius = newRadius;
    }

    /**
     * \ingroup GLVisualization
     * Start the rotation. Use this method in association with the left click.
     * Here you must give directly the coordinates of the mouse as the glut functions extract. This method supposes that the 0,0 is in the upper-left part of the screen
     * \param _x Horizontal position of the mouse (0,0) = upperleft corner (w,h) = lower right
     * \param _y Vertical position of the mouse (0,0) = upperleft corner (w,h) = lower right
     *
     **//*
    void startRotation(int _x, int _y)
    {  int x = ( (_x)-(width/2) );
        int y = ((height/2)-_y);

        startRotationVector = convertXY(x,y);
        startRotationVector.normalize();

        currentRotationVector=  startRotationVector;
        isRotating = true;
    }

    /**
     * \ingroup GLVisualization
     * Update the rotation. Use this method in association with the drag event.
     * Here you must give directly the coordinates of the mouse as the glut functions extract. This method supposes that the 0,0 is in the upper-left part of the screen
     * \param _x Horizontal position of the mouse (0,0) = upperleft corner (w,h) = lower right
     * \param _y Vertical position of the mouse (0,0) = upperleft corner (w,h) = lower right
     **//*
    void updateRotation(int _x, int _y)
    {  int x = ( (_x)-(width/2) );
        int y = ((height/2)-_y);

        currentRotationVector = convertXY(x,y);

        currentRotationVector.normalize();
    }

    /**
     * \ingroup GLVisualization
     * Apply the computed rotation matrix
     * This method must be invoked inside the \code glutDisplayFunc() \endcode
     *
     **//*
    void applyRotationMatrix()
    {  if (isRotating)
    {  // Do some rotation according to start and current rotation vectors
        //cerr << currentRotationVector.transpose() << " " << startRotationVector.transpose() << endl;
        if ( ( currentRotationVector.moins(startRotationVector)).norme() > 1E-6 )
        {  Point3D rotationAxis = currentRotationVector.prodVect(startRotationVector);
            rotationAxis.normalize();

            double val = currentRotationVector.prodScalaire(startRotationVector);
            if(val > (1-1E-10))
                val=1.0; else val=val;
            double rotationAngle = Math.acos(val) * 180.0f/(float)Math.PI;

            // rotate around the current position
      /*      applyTranslationMatrix(true);
            glRotatef(rotationAngle * 2, -rotationAxis.x(),  -rotationAxis.y(),-rotationAxis.z());
            applyTranslationMatrix(false);
        }
    }
        glMultMatrixf(startMatrix);
    }

    /**
     * \ingroup GLVisualization
     * Stop the current rotation and prepare for a new click-then-drag event
     *
     **//*
    void stopRotation()
    {

        glMatrixMode(GL_MODELVIEW);
        glLoadIdentity();
        applyRotationMatrix();
        // set the current matrix as the permanent one
        glGetFloatv(GL_MODELVIEW_MATRIX, startMatrix);
        isRotating = false;
    }


    /**
     * \ingroup GLVisualization
     * Apply the translation matrix to the current transformation (zoom factor)
     **//*
    void applyTranslationMatrix(boolean reverse)
    {  float factor = (reverse?-1.0f:1.0f);
        float tx = transX + (currentTransX - startTransX)*TRANSLATION_FACTOR;
        float ty = transY + (currentTransY - startTransY)*TRANSLATION_FACTOR;
        glTranslatef(factor*tx,  factor*(-ty), 0);
    }

    /**
     * \ingroup GLVisualization
     * Maps the mouse coordinates to points on a sphere, if the points lie outside the sphere, the z is 0, otherwise is \f$ \sqrt(r^2 - (x^2+y^2) ) \f$ where \f$ x,y \f$
     * are the window centric coordinates of the mouse
     * \param x Mouse x coordinate
     * \param y Mouse y coordinate
     **//*
    Point3D convertXY(int x, int y)
    {

        int d = x*x+y*y;
        float radiusSquared = ballRadius*ballRadius;
        if (d > radiusSquared)
        {  return new Point3D((double)x,(double)y, 0. );
        }
        else
        {  return new Point3D((double)x,(double)y, Math.sqrt(radiusSquared - d));
        }
    }

    /**
     * \ingroup GLVisualization
     * Reset the current transformation to the identity
     **//*
    void reset()
    {  fov = INITIAL_FOV;
        // reset matrix
        memset(startMatrix, 0, sizeof(startMatrix));
        startMatrix[0] = 1;
        startMatrix[1] =0;
        startMatrix[2] = 0;
        startMatrix[3] = 0;
        startMatrix[4] = 0;
        startMatrix[5] =1;
        startMatrix[6] = 0;
        startMatrix[7] = 0;
        startMatrix[8] = 0;
        startMatrix[9] =0;
        startMatrix[10] = 1;
        startMatrix[11] = 0;
        startMatrix[12] = 0;
        startMatrix[13] =0;
        startMatrix[14] = 0;
        startMatrix[15] = 1;

        transX = transY = 0;
        startTransX = startTransY = currentTransX = currentTransY = 0;
    }


private int INITIAL_FOV = 30;
private float TRANSLATION_FACTOR = 0.01f;*/
/*
* \class Arcball
* \ingroup GLVisualization
* \brief Arcball is a method to manipulate and rotate objects in 3D intuitively.
*
* The motivation behind the trackball (aka arcball) is to provide an intuitive user interface for complex 3D
* object rotation via a simple, virtual sphere - the screen space analogy to the familiar input device bearing
* the same name.
*
* The sphere is a good choice for a virtual trackball because it makes a good enclosure for most any object;
* and its surface is smooth and continuous, which is important in the generation of smooth rotations in response
* to smooth mouse movements.
* Any smooth, continuous shape, however, could be used, so long as points on its surface can be generated
*  in a consistent way.
* The algorithm for accomplishing this, needs to perform the following steps (not neseccarily in order).
*
*
*
*
* \b ArcBall Algorithm made easy
*  - Detect the left-button of the mouse being depressed.
*  - Keep track of the last known mouse position.
*  - Treat the mouse position as the projection of a point on the hemi-sphere down to the image plane (along the z-axis), and determine that point on the hemi-sphere.
*  - Detect the mouse movement
*  - Determine the great circle connecting the old mouse-hemi-sphere point to the current mouse-hemi-sphere point.
*  - Calculate the normal to this plane. This will be the axis about which to rotate.
*  - Set the OpenGL state to modify the MODELVIEW matrix.
*  - Read off the current matrix, since we want this operation to be the last transformation, not the first, and OpenGL does things LIFO.
*  - Reset the model-view matrix to the identity
*  - Rotate about the axis
*  - Multiply the resulting matrix by the saved matrix.
*  - Force a redraw of the scene.
*
* An example of the code for using successfully this class is the following:
* First set the radius of the arcball by using the appropriate method when you call the handle to the GLUT resize method (this is usually accomplished with a
* \code
* void handleResize(int w, int h)
* \endcode
* function in GLUT (if you are using Qt or other, please refer to the relative API ).
* An example of a \code handleResize(int w, int h) \endcode function is the following:
* \code
* void handleResize(int w, int h)
* {
*   arcball.setWidthHeight(w, h);
*   glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
*   glViewport(0, 0, w, h);
*
*   glMatrixMode(GL_PROJECTION);
*   glLoadIdentity();
*   gluPerspective(viewAngle, (float)w / (float)w, zNear, zFar );
*
*   glMatrixMode(GL_MODELVIEW);
* }
* \endcode
*
*
These are the two functions (GLUT) that control the mouse events:
* \code
* void mouseFunc(int state, int button, int _x , int _y)
* {
*   if ( button == GLUT_LEFT_BUTTON )
*       arcball.startRotation(_x,_y);
*   else
*       arcball.stopRotation();
*
*
*   glutPostRedisplay();
* }
*
* void mouseDrag(int _x, int _y)
* {
*
*   arcball.updateRotation(_x,_y);
*   glutPostRedisplay();
* }
*
* \endcode
*
*/

/*
    class Arcball
    {
        private:
        float fov;
        int fovStartY;
        int fovCurrentY;

        float transX, transY;
        float currentTransX, currentTransY;
        float startTransX, startTransY;

        GLMatrix startMatrix;
        GLMatrix currentMatrix;
        Vector3d startRotationVector;
        Vector3d currentRotationVector;
        bool isRotating;
        float ballRadius;
        double residualSpin;
        static const float INITIAL_FOV;
        static const float MINIMAL_FOV;
        static const float TRANSLATION_FACTOR;

        Vector3d convertXY(int x, int y);
        int width, height;
        public:
        Arcball();

        void setWidthHeight(int w, int h);
        void startRotation(int x, int y);
        void updateRotation(int x, int y);
        void stopRotation();


        void applyTranslationMatrix(bool reverse = false);
        void applyRotationMatrix();

        void setRadius(float newRadius);
        void reset();
    };

*/
}
