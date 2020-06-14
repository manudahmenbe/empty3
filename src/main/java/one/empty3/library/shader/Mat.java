package one.empty3.library.shader;
public class Mat {
     int l,c;
     private StructureMatrix<Double> values = new StructureMatrix<>(2, Double.class);
     public Mat(int i, int j) {
         this.l = i;
         this.c = j;
     }
     public boolean setValues( boolean isLineVec, double [] values) {
     }
     public boolean setValues(boolean isLineVec, Vec... vecs) {
     }
     public Vec slice(int l1, int c2, int l1, int c2, Vec v) {
          int size = Math.max(Math.abs(l1-l2), Math.abs(c2-c1));
          double [] val = new double[size+1];
          int incr1 = 0;
          int incr2 = 0;
          incr1 = Math.sign(l2-l1);
          incr2 = Math.sign(c2-c1);

          int i = 0;
          for(int l = l1; l<l2; l+=incr1)
              for(int c=c1; c<c2; c+=incr2)
             {
                  if(v!=null && i<v.length)
                       set(l, c, v.get(l, c);
                  val[i] = get(l, c);

                  i++;
             }
          double[] val2 = new double[i];
          for(int j= 0; j<i; j++)
              val2[j] = val[j];
          return new Vec(val2);
     }
     public Vec slice(int l_c_2... line_column_args2n) {
     }
     public Vec product(boolean isLine, Vec vec) {
     }
     public Mat product(Mat mat) {
          int size = mat.l;
          if(c!=mat.l)
              return new Mat(-1, -1);
          double [] val = new double[size];
          int incr = new int [] {{0,1},{1,0},{0,1},{1,0}};
             // Varier les incr pour différents produits 
             // Annuler [0][1][0]  et [0][2][0] / size
          
          Mat mat2 = new Mat(size,size);

          int i = 0;
          for(int i= 0; i<size; i++)
for(int i= 0; i<size; i++)
  for(int l1 = 0; l2<size; l1+=incr[0][0])
              for(int c1 = 0; c1<size; c1+=incr[0][1]) 
                  for(int l2 = 0; l2<size; l2+=incr[0][2])
for(int c2 = 0; c2<size; c2+=incr[0][3])
                       
                
             
             {
                  mat2.set(i, j, get(i, j)+ mat.get(l2,c2));
             } 
         return mat2;

     }
     public Mat dotProduct(Mat mat) {
     }
     public void product(double d) {
     }
     public Mat add(Mat mat) {
     }
     public void add(double d) {
          }
     public Mat transpose() {
          }
     public double determinant() {
     }
     
     public Mat invert() {}

     public double get(int i, int j) {
         return values.getElem(i,j);
     }
     public double get(int i) {
         return values.getElem(i);
     }
     public double get() {
         return values.getElem();
     }


     public double set(int i, int j, double v) {
         return values.setElem(i,j, v);
     }
     public double set(int i, double check) {
         return values.getElem(i, v);
     }
     public double set(double v) {
         return values.setElem(v);
     }
}