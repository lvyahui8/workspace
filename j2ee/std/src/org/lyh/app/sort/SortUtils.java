package org.lyh.app.sort;

/**
 * Created by admin on 2015/7/14.
 */
public class SortUtils<T> {
    protected static <T> void swap(T arr[],int i,int j){

    }
    public static <T> void ksort(T arr[] , int l , int h){
        if(h < l + 2){
            return ;
        }
        int e = h,p = l;
        while(l < h){
//            while(++l < e && arr[l] <= arr[p]);
//            while(--h > p && arr[h] >= arr[p]);
//            if(l < h) swap(arr,l,h);
        }
        
        //swap(arr,h,p);
        //ksort(arr,p,h);
        //ksort(arr,l,e);4
        System.out.println("nihao");
    }
}
