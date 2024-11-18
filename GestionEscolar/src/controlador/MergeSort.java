/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author Saúl Ojeda
 */
public class MergeSort {
    static int conteo_operaciones;

    public static int iniciarMergeSort(int[] array, int first, int last){
        conteo_operaciones = 0;
        mergeSort(array, first, last);
        return conteo_operaciones;
    }

    public static void mergeSort(int[] array, int first, int last){
        conteo_operaciones++;
        int mid;
        if(first < last){
            mid = (first+last)/2;
            mergeSort(array, first, mid);
            mergeSort(array, mid+1, last);
            merge(array, first, mid, last);
        }
    }
    public static void merge(int[] array, int first, int mid, int last){
        int[] array2 = new int[last-first+1];
        int i=first, j=mid+1, k=0;
        while(i <= mid && j <= last){
            conteo_operaciones++;
            if(array[i] < array[j])
                array2[k++] = array[i++];
            else
                array2[k++] = array[j++];
        }
        while(i <= mid){
            array2[k++] = array[i++];
            conteo_operaciones++;
        }
        while(j <= last){
            array2[k++] = array[j++];
            conteo_operaciones++;
        }
        for(i = last; i >= first; i--)
            array[i] = array2[--k];
    }
}
