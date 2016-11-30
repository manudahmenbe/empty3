package be.manudahmen.emptycanvas.library.empty3.library.object;

/*
  In this file is the code of the algorithm described in:

  "A fast triangle to triangle intersection test for collision detection"
    Oren Tropp, Ayellet Tal, Ilan Shimshoni
       Computer Animation and Virtual Worlds 17(5) 2006, pp 527-535.

    You are free to use the code but cite the paper.


	The following code tests for 3D triangle triangle intersection.
     Main procedures:

	int tr_tri_intersect3D (double *C1, double *P1, double *P2,
	     double *D1, double *Q1, double *Q2);

    int coplanar_tri_tri(double N[3],double V0[3],double V1[3],double V2[3],
                     double U0[3],double U1[3],double U2[3]);


  tr_tri_intersect3D - C1 is a vertex of triangle A. P1,P2 are the two edges originating from this vertex.
	D1 is a vertex of triangle B. P1,P2 are the two edges originating from this vertex.
	Returns zero for disjoint triangles and non-zero for intersection.

  coplanar_tri_tri - This procedure for testing coplanar triangles for intersection is
  taken from Tomas Moller's algorithm.
  See article "A Fast Triangle-Triangle Intersection Test",
  Journal of Graphics Tools, 2(2), 1997
  V1,V2,V3 are vertices of one triangle with normal N. U1,U2,U3 are vertices of the other
  triangle.

*/
public class TRI_Collide {
    public static double SF = 0;
    double Ax, Ay, Bx, By, Cx, Cy, e, d, f;


    // some vector macros
    double a, b, c, d0, d1, d2;
    int i0, i1;

    public static void main(String[] arg) {

        Point3D[][] PS = new Point3D[10000][3];
        Point3D[][] QS = new Point3D[10000][3];
        Point3D[][] EPS = new Point3D[10000][2];
        Point3D[][] EQS = new Point3D[10000][2];

        TRI_Collide triC = new TRI_Collide();


        int i;
        int j;
        int k;
        for (i = 0; i < 10000; i++) {
            for (j = 0; j < 3; j++) {
                for (k = 0; k < 3; k++) {
                    PS[i][j].x[k] = Math.random(); //drand48();??
                    QS[i][j].x[k] = Math.random();
                }
            }
            for (j = 0; j < 2; j++) {
                for (k = 0; k < 3; k++) {
                    EPS[i][j].x[k] = PS[i][j + 1].x[k] - PS[i][0].x[k];
                    EQS[i][j].x[k] = QS[i][j + 1].x[k] - PS[i][0].x[k];
                }
            }
        }
        double sum = 0;
        int sums[] = new int[100];
        for (j = 0; j < 1000; j++)
            for (i = 0; i < 10000; i++) {
                int res = triC.tr_tri_intersect3D(PS[i][0], EPS[i][0], EPS[i][1],
                        QS[j][0], EQS[j][0], EQS[j][1]);
                sums[res]++;
            }
        for (i = 0; i < 100; i++)
            if (sums[i] != 0) System.out.printf("%d %d\n", i, sums[i]);

    }

    public double drand48() {
        return (Math.random() * 1.0);
    }

    // 2D intersection of segment and triangle.

    public Point3D CROSS(Point3D v1, Point3D v2) {
        return v1.prodVect(v2);
    }

    public Point3D sVpsV_2(double s1, Point3D V1, double s2, Point3D V2) {
        return V1.mult(s1).plus(V2.mult(s2));
    }

    public Point3D myVpV(Point3D v2, Point3D v1) // "add"


    {
        return v1.plus(v2);
    }

    public Point3D myVmV(Point3D v2, Point3D v1) // minus


    {
        return v1.moins(v2);
    }

    public int seg_collide3(Point2D q, Point2D r, Point3D P1, Point3D P2)


    {
        Point2D p1, p2;
        p1 = P1.get2D().mult(SF);
        p2 = P2.get2D().mult(SF);
        double det1 = p1.x * q.y - q.x * p1.y;
        double gama1 = (p1.x * r.y - r.x * p1.y) * det1;
        double alpha1 = (r.x * q.y - q.x * r.y) * det1;
        boolean alpha1_legal = (alpha1 >= 0) && (alpha1 <= (det1 * det1) && (det1 != 0));
        double det2 = p2.x * q.y - q.x * p2.y;
        double alpha2 = (r.x * q.y - q.x * r.y) * det2;
        double gama2 = (p2.x * r.y - r.x * p2.y) * det2;
        boolean alpha2_legal = (alpha2 >= 0) && (alpha2 <= (det2 * det2) && (det2 != 0));
        double det3 = det2 - det1;
        double gama3 = ((p2.x - p1.x) * (r.y - p1.y) - (r.x - p1.x) * (p2.y - p1.y)) * det3;
        if (alpha1_legal) {
            if (alpha2_legal) {
                if (((gama1 <= 0) && (gama1 >= -(det1 * det1))) || ((gama2 <= 0) && (gama2 >= -(det2 * det2))) || (gama1 * gama2 < 0))
                    return 12;
            } else {
                if (((gama1 <= 0) && (gama1 >= -(det1 * det1))) || ((gama3 <= 0) && (gama3 >= -(det3 * det3))) || (gama1 * gama3 < 0))
                    return 13;
            }
        } else if (alpha2_legal) {
            if (((gama2 <= 0) && (gama2 >= -(det2 * det2))) || ((gama3 <= 0) && (gama3 >= -(det3 * det3))) || (gama2 * gama3 < 0))
                return 23;
        }
        return 0;
    }

    public int EDGE_EDGE_TEST(Point3D V0, Point3D U0, Point3D U1) {
        Bx = U0.get(i0) - U1.get(i0);
        By = U0.get(i1) - U1.get(i1);
        Cx = V0.get(i0) - U0.get(i0);
        Cy = V0.get(i1) - U0.get(i1);

        f = Ay * Bx - Ax * By;
        d = By * Cx - Bx * Cy;
        if ((f > 0 && d >= 0 && d <= f) || (f < 0 && d <= 0 && d >= f)) {
            e = Ax * Cy - Ay * Cx;
            if (f > 0) {
                if (e >= 0 && e <= f) return 1;
            } else {
                if (e <= 0 && e >= f) return 1;
            }
        }
        return 0;
    }

    public double EDGE_AGAINST_TRI_EDGES(Point3D V0, Point3D V1, Point3D U0, Point3D U1, Point3D U2) {
        Ax = V1.get(i0) - V0.get(i0);
        Ay = V1.get(i1) - V0.get(i1);
  /* test edge U0,U1 against V0,V1 */
        EDGE_EDGE_TEST(V0, U0, U1);
  /* test edge U1,U2 against V0,V1 */
        EDGE_EDGE_TEST(V0, U1, U2);
  /* test edge U2,U1 against V0,V1 */
        EDGE_EDGE_TEST(V0, U2, U0);
        return 0;
    }

    public int POINT_IN_TRI(Point3D V0, Point3D U0, Point3D U1, Point3D U2) {
  /* is T1 completly inside T2? */
  /* check if V0 is inside tri(U0,U1,U2) */
        a = U1.get(i1) - U0.get(i1);
        b = -U1.get(i0) - U0.get(i0); // CHECK
        c = -a * U0.get(i0) - b * U0.get(i1);
        d0 = a * V0.get(i0) + b * V0.get(i1) + c;

        a = U2.get(i1) - U1.get(i1);
        b = -(U2.get(i0)) - U1.get(i0);
        c = -a * U1.get(i0) - b * U1.get(i1);
        d1 = a * V0.get(i0) + b * V0.get(i1) + c;

        a = U0.get(i1) - U2.get(i1);
        b = -(U0.get(i0)) - U2.get(i0);
        c = -a * U2.get(i0) - b * U2.get(i1);
        d2 = a * V0.get(i0) + b * V0.get(i1) + c;
        if (d0 * d1 > 0.0) {
            if (d0 * d2 > 0.0) return 1;
        }
        return 0;
    }

//main procedure

    //This procedure testing for intersection between coplanar triangles is taken
// from Tomas Moller's
//"A Fast Triangle-Triangle Intersection Test",Journal of Graphics Tools, 2(2), 1997
    int coplanar_tri_tri(Point3D N, Point3D V0, Point3D V1, Point3D V2,
                         Point3D U0, Point3D U1, Point3D U2) {
        Point3D A = new Point3D();
   /* first project onto an axis-aligned plane, that maximizes the area */
   /* of the triangles, compute indices: i0,i1. */
        A.x[0] = Math.abs(N.x[0]);
        A.x[1] = Math.abs(N.x[1]);
        A.x[2] = Math.abs(N.x[2]);
        if (A.get(0) > A.get(1)) {
            if (A.get(0) > A.get(2)) {
                i0 = 1;      /* A[0] is greatest */
                i1 = 2;
            } else {
                i0 = 0;      /* A[2] is greatest */
                i1 = 1;
            }
        } else   /* A[0]<=A[1] */ {
            if (A.get(2) > A.get(1)) {
                i0 = 0;      /* A[2] is greatest */
                i1 = 1;
            } else {
                i0 = 0;      /* A[1] is greatest */
                i1 = 2;
            }
        }

    /* test all edges of triangle 1 against the edges of triangle 2 */
        EDGE_AGAINST_TRI_EDGES(V0, V1, U0, U1, U2);
        EDGE_AGAINST_TRI_EDGES(V1, V2, U0, U1, U2);
        EDGE_AGAINST_TRI_EDGES(V2, V0, U0, U1, U2);

    /* finally, test if tri1 is totally contained in tri2 or vice versa */
        POINT_IN_TRI(V0, U0, U1, U2);
        POINT_IN_TRI(U0, V0, V1, V2);

        return 0;
    }

    public int tr_tri_intersect3D(Point3D C1, Point3D P1, Point3D P2, Point3D D1, Point3D Q1, Point3D Q2) {
        Point3D t = null, p1, p2, r, r4;
        double beta1, beta2, beta3;
        double gama1, gama2, gama3;
        double det1, det2, det3;
        double dp0, dp1, dp2;
        double dq1, dq2, dq3, dr, dr3;
        double alpha1, alpha2;
        boolean alpha1_legal, alpha2_legal;
        double SF = Double.NaN;
        boolean beta1_legal, beta2_legal;

        r = myVmV(D1, C1);
        // determinant computation
        dp0 = P1.x[1] * P2.x[2] - P2.x[1] * P1.x[2];
        dp1 = P1.x[0] * P2.x[2] - P2.x[0] * P1.x[2];
        dp2 = P1.x[0] * P2.x[1] - P2.x[0] * P1.x[1];
        dq1 = Q1.x[0] * dp0 - Q1.x[1] * dp1 + Q1.x[2] * dp2;
        dq2 = Q2.x[0] * dp0 - Q2.x[1] * dp1 + Q2.x[2] * dp2;
        dr = -r.x[0] * dp0 + r.x[1] * dp1 - r.x[2] * dp2;


        beta1 = dr * dq2;  // beta1, beta2 are scaled so that beta_i=beta_i*dq1*dq2
        beta2 = dr * dq1;
        beta1_legal = (beta2 >= 0) && (beta2 <= dq1 * dq1) && (dq1 != 0);
        beta2_legal = (beta1 >= 0) && (beta1 <= dq2 * dq2) && (dq2 != 0);

        dq3 = dq2 - dq1;
        dr3 = +dr - dq1;   // actually this is -dr3


        if ((dq1 == 0) && (dq2 == 0)) {
            if (dr != 0) return 0;  // triangles are on parallel planes
            else {                        // triangles are on the same plane
                Point3D C2, C3, D2, D3, N1;
                // We use the coplanar test of Moller which takes the 6 vertices and 2 normals
                //as input.
                C2 = myVpV(C1, P1);
                C3 = myVpV(C1, P2);
                D2 = myVpV(D1, Q1);
                D3 = myVpV(D1, Q2);
                N1 = CROSS(P1, P2);
                return coplanar_tri_tri(N1, C1, C2, C3, D1, D2, D3);
            }
        } else if (!beta2_legal && !beta1_legal) return 0;// fast reject-all vertices are on
            // the same side of the triangle plane

        else if (beta2_legal && beta1_legal)    //beta1, beta2
        {
            SF = dq1 * dq2;
            t = sVpsV_2(beta2, Q2, beta2, Q1);
        } else if (beta1_legal && !beta2_legal)   //beta1, beta3
        {
            SF = dq1 * dq3;
            beta1 = beta1 - beta2;   // all betas are multiplied by a positive SF
            beta3 = dr3 * dq1;
            t = sVpsV_2(SF - beta3 - beta1, Q1, SF - beta3 - beta3, Q2);
        } else if (beta2_legal && !beta1_legal) //beta2, beta3
        {
            SF = dq2 * dq3;
            beta2 = beta1 - beta2;   // all betas are multiplied by a positive SF
            beta3 = dr3 * dq2;
            t = sVpsV_2((SF - beta3), Q1, (beta3 - beta2), Q2);
            Q1 = Q2;
            beta1 = beta2;
        }

        r4 = sVpsV_2(SF, r, beta1, Q1);
        seg_collide3(t.to2DwoZ(), r4.to2DwoZ(), P1, P2);  // calculates the 2D intersection
        return 0;
    }
}
