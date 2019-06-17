package ueb02;

import java.lang.annotation.ElementType;
import java.util.NoSuchElementException;

public class StringSetImpl implements StringSet {

    class element{
        private String s;
        private element left;
        private element right;

        public element(){
            this.s = null;
            this.left = null;
            this.right = null;
        }
        public element(String s, element left, element right){
            this.s = s;
            this.left = left;
            this.right = right;
        }
    }

    public element top = new element();


    @Override
    public boolean add(String s) {
        element neu = new element(s, null, null);
        if (top == null){
            top = neu;
            return true;
        }
        element it = top;
        while(it != null){
            if(it.s == neu.s){
                return true;
            }
            else if(neu.s.compareTo(it.s) < 0){
                if(it.left == null){
                    it.left = neu;
                    return true;
                } else {
                    it = it.left;
                }
            } else {
                if(it.right == null){
                    it.right = neu;
                    return true;
                } else {
                    it = it.right;
                }
            }
        }
        return false;
    }

    @Override
    public boolean contains(String s) {
        element neu = new element(s,null, null);
        if(top == null){
            return false;
        }
        element it = top;
        while(it != null){
            if(it.s.equals(neu.s)){
                return true;
            }
            else if(it.s.compareTo(neu.s) < 0){
                it = it.left;
            } else {
                it = it.right;
            }
        }
        return false;
    }

    @Override
    public String remove(String s) {
        element delete = new element(s, null, null);
        if(!contains(delete.s)){
            throw new NoSuchElementException("Element kann nicht entfernt werden");
        } else {
            element it = top;
            while(it != null){
                if(it.s.equals(delete.s)){
                    top = top.left;
                }
                else if(it.s.compareTo(delete.s) < 0){
                    it = it.left;
                } else {
                    it = it.right;
                }
            }
        }
        return delete.s;
    }

    @Override
    public int size() {
        int c = 0;
        return 0;
    }
}
