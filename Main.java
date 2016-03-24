import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static class MDArray {
        public int dim = 0;
        public List arr;

        MDArray(int dim) {
            this.dim = dim;
            this.arr = new ArrayList();
            this.build(this.arr, this.dim);
            this.dim = 5;
            this.modify(this.arr, this.dim, 2);
          //  setValue(this.arr, 5, 3);
        }

        public void build(List array, int dim) {
            dim--;
            if(dim == 0) {
                return;
            }
            List newDimArray = new ArrayList();
            for(int i = 0; i < this.dim; i++) {
                array.add(newDimArray);
            }
            build(newDimArray, dim);
        }

        public void modify(List array, int dim, int value){

            int end = 3;
            dim--;
            ListIterator it = array.listIterator();

            while(it.hasNext() && dim != 0){

                List lst = (List)it.next();
                List newlist = new ArrayList();


                for (int z = 0; z < 5; z++) {
                    newlist.add(value);
                    lst.set(z, newlist);
                }

                modify(lst, dim, value);
            }
        }


        public void setValue (List array, int value, int index ){

          //  System.out.println(((ArrayList) array.set(index,3)).set(index,3));
        }
    }
    public static void main(String[] args) {
        MDArray mda = new MDArray(5);
        System.out.println("==> " + mda.arr.get(0));
    }
}
