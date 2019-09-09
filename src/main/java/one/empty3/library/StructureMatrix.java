package one.empty3.library;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by manue on 07-09-19.
 */
public class StructureMatrix<T>  {
    private static final int INSERT_ROW = 0;
    private static final int INSERT_COL = 1;
    private int dim;
    public T data0d;
    public List<T> data1d;
    public List<List<T>> data2d;

    public StructureMatrix()
    {
        dim = -1;
    }

    public StructureMatrix(int dim, int [] sizes)
    {
        this.dim = dim;
        if(dim==0)
        {
            data0d = null;
        }
        if(dim==1)
        {
            data1d = new ArrayList<>();
            for(int i=0; i<sizes[0]; i++)
                data1d.add(null);

        }
        if(dim==2)
        {
            data2d = new ArrayList<List<T>>();

            for(int i=0; i<sizes[0]; i++) {
                data2d.add(new ArrayList<T>());
                for(int j=0; j<sizes[1]; j++)
                {
                    data2d.get(i).add(null);
                }
            }
        }
    }
    public StructureMatrix(T array)
    {
        dim=0;
        data0d = array;
    }
    public StructureMatrix(T[] array)
    {
        dim=1;
        data1d = new ArrayList<T>();
        for(int i= 0; i<array.length; i++)
            data1d.add(array[i]);
    }
    public StructureMatrix(T[][] array)
    {
        dim=2;
        data2d = new ArrayList<List<T>>();
        for(int i= 0; i<array.length; i++) {
            addRow();
            for(int j=0; j<array[i].length; j++)
                data2d.get(i).add(array[i][j]);
        }

    }

    public StructureMatrix(List<T> coordArr) {
        dim = 1;
        data1d = new ArrayList<>();
        for(int i=0; i<coordArr.size(); i++)
            data1d.add(coordArr.get(i));
    }

    public StructureMatrix(int dim) {
        this.dim = dim;
        if(dim==1)
            data1d = new ArrayList<T>();
        if(dim==2)
            data2d = new ArrayList<List<T>>();
    }

    public void setElem(T value)
    {
        this.data0d = value;
    }
    public void setElem(T elem, int i)
    {
        data1d.set(i, elem);
    }
    public void setElem(T elem, int i, int j)
    {
        data2d.get(i).set(j, elem);
    }

    public T getElem(int [] indices)
    {
        if(dim==0) {
            return this.data0d;
        }
        if(dim==1)
        {
            return data1d.get(indices[0]);
        }
        if(dim==2)
        {
            return data2d.get(indices[0]).get(indices[1]);
        }
        return null;
    }
    public T getElem() {

        if(dim==0)
            return this.data0d;
        System.err.println("getElem dim= " + dim +"!=0");
        return null;
    }
    public T getElem(int i) {
        if(dim==1)
        {
            return data1d.get(i);
        }
        System.err.println("getElem dim= " + dim +"!=1");
        return null;
    }
    public T getElem(int i, int j) {
        if(dim==2)
        {
            return data2d.get(i).get(j);
        }
        System.err.println("getElem dim= " + dim +"!=2");
        return null;
    }

    public T getData0d()
    {
        return data0d;
    }
    public List<T> getData1d()
    {
        return data1d;
    }
    public List<List<T>> getData2d()
    {
        return data2d;
    }

    public void insert(int pos, int rowCol, T value)
    {
        if(dim==1)
            data1d.add(pos, value);
        if(dim==2)
        {
            if(rowCol==INSERT_ROW)
            {
                ArrayList<T> ins = new ArrayList<>();
                for(int i=0; i<data2d.get(0).size(); i++)
                    ins.add(value);
                data2d.add(pos, ins);

            }
            else if(rowCol==INSERT_COL)
            {
                for(int i=0; i<data2d.size(); i++)
                {
                    data2d.get(pos).add(i, value);
                }
            }
        }
    }
    public void delete(int pos, int rowCol)
    {
        if(dim==1)
            data1d.remove(pos);
        if(dim==2)
        {
            if(rowCol==INSERT_ROW)
            {
                data2d.remove(pos);

            }
            else if(rowCol==INSERT_COL)
            {
                for(int i=0; i<data2d.size(); i++)
                {
                    data2d.get(pos).remove(i);
                }
            }
        }
    }
    public void insert(int i, T value)
    {
        if(dim==1)
            data1d.add(i, value);
    }

    public void add(int dim, T value)
    {
        if(this.dim==0)
        {
            data0d = value;
        }
        if(this.dim==1)
        {
            data1d.add(value);
        }
        if(this.dim==2)
        {
            int ind1 = data2d.size();
            data2d.get(ind1).add(value);
        }
    }
    public void addRow()
    {
        if(this.dim==2)
        {
            int ind1 = data2d.size();
            data2d.add(new ArrayList<T>());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StructureMatrix<?> that = (StructureMatrix<?>) o;

        if (dim != that.dim) return false;
        if (dim==0 && !data0d.equals(that.data0d)) return false;
        if (dim==1 && !data1d.equals(that.data1d)) return false;
        if(dim==2 && !data2d.equals(that.data2d)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = dim;
        result = 31 * result + data0d.hashCode();
        result = 31 * result + data1d.hashCode();
        result = 31 * result + data2d.hashCode();
        return result;
    }

    public int getDim() {
        return dim;
    }

    public void setDim(int dim) {
        this.dim = dim;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("structure(\n");
        s.append("(dim:"+dim+")");
        switch (dim)
        {
            case 0:
                s.append("(data : {"+data0d.toString()+"} )");
                break;
            case 1:
                s.append("(data : (");
                data1d.forEach(new Consumer<T>() {
                    @Override
                    public void accept(T t) {
                        s.append("("+t.toString()+")");
                    }
                });
                break;
            case 2:
                s.append("(data : (");
                data2d.forEach(new Consumer<List<T>>() {
                    @Override
                    public void accept(List<T> ts) {
                        s.append("( ");

                        ts.forEach(new Consumer<T>() {
                            @Override
                            public void accept(T t) {
                                s.append("("+t.toString()+")");
                            }
                        });

                        s.append(" )\n");

                    }
                });
                s.append("\n)\n");
                break;


        }
        return s.toString();
    }
}
