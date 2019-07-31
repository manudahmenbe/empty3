package one.empty3.library.core;

import one.empty3.library.Representable;
/**
 * Created by manue on 24-07-19.
 */
public class Arrays<T>
{

    int POS_BEGIN = 0;
    int POS_END = -1;
    int DIM_0;
    int DIM_1;


    public  T[] insert(T[] array, int pos)
    {
        T[] copyOf = java.util.Arrays.copyOf(array, array.length + 1);
        if(pos==POS_BEGIN)
            pos = 0;
        if(pos==POS_END)
            pos = array.length;
        int i = pos;
        copyOf[pos] = null;
        i++;
        while(i<copyOf.length)
        {
            copyOf[i] = array[i];
            i++;
        }
        return copyOf;
    }
    
    
    public  Representable[][] insert(Class clazz, Representable[][] array, int pos1, int pos2, int dim)  {
        Representable[][] copy = null;
        if(dim==DIM_0)
        {
            copy = new Representable[array.length+1][array[0].length];
        }
        else if(dim==DIM_1)
        {
            copy = new Representable[array.length][array[0].length+1];
        }
        else
        {}
        for(int i=0; i<array.length; i++)
        {
            for(int j=0; j<array[i].length; j++)
            {
                copy[i][j] = copy[i][j];
                if(pos1==i)
                    i++;
                else if(pos2==j)
                    j++;
            }
        }


        return copy;
    }
    public  Double[][] insert(Class clazz, Double[][] array, int pos1, int pos2, int dim)  {
        Double[][] copy = null;
        if(dim==DIM_0)
        {
            copy = new Double[array.length+1][array[0].length];
        }
        else if(dim==DIM_1)
        {
            copy = new Double[array.length][array[0].length+1];
        }
        else
        {}
        for(int i=0; i<array.length; i++)
        {
            for(int j=0; j<array[i].length; j++)
            {
                copy[i][j] = copy[i][j];
                if(pos1==i)
                    i++;
                else if(pos2==j)
                    j++;
            }
        }


        return copy;
    }
}
