/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jonathan Aguilera
 */
public class EVA3_1_ORDENAMIENTO {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int iLargo=10;
        int[] aiPrueba = new int [iLargo];
        int[] aiPrueba2 = new int [iLargo];
        int[] aiPrueba3 = new int [iLargo];
        int[] aiPrueba4 = new int [iLargo];
        for (int i = 0; i < aiPrueba.length; i++) {
            aiPrueba[i] = (int)(Math.random()*100);
            aiPrueba2[i] = aiPrueba[i];
            aiPrueba3[i] = aiPrueba[i];
            aiPrueba4[i] = aiPrueba[i];
        }
        long lIni=System.nanoTime();
        long lFin=System.nanoTime();
        long lTotTime= lFin-lIni;
        //  long lInim = System.currentTimeMillis();
        //long lFinm = System.currentTimeMillis();
        System.out.println("Datos de origen");
        imprimirArreglo(aiPrueba);
        //SelectionSort
        System.out.println("Arreglo ordenado con Selectionsort");
        lIni = System.nanoTime();
        selectionSort(aiPrueba);
        lFin = System.nanoTime();
        lTotTime= lFin-lIni;
        System.out.println("Tardo: "+ lTotTime+" Nanosegundos");
        imprimirArreglo(aiPrueba);
        
        //Tambien imprimir y contar el tiempo con Con los otros metodos ( Con los mismos datos);
        
        //InsertionSort
        System.out.println("Arreglo ordenado con Insertionsort");
        lIni = System.nanoTime();
        insertionSort(aiPrueba3);
        lFin = System.nanoTime();
        lTotTime= lFin-lIni;
        System.out.println("Tardo: "+ lTotTime+" Nanosegundos");
        imprimirArreglo(aiPrueba3);
        
        //BubbleSort
        System.out.println("Arreglo ordenado con BubbleSort");
        lIni = System.nanoTime();
        bubbleSort(aiPrueba2);
        lFin = System.nanoTime();
        lTotTime= lFin-lIni;
        System.out.println("Tardo: "+ lTotTime+" Nanosegundos");
        imprimirArreglo(aiPrueba2);
        
        //QuickSort
        System.out.println("Arreglo ordenado con QuickSort");
        lIni = System.nanoTime();
        quickSort(aiPrueba4, 0, aiPrueba4.length - 1);
        lFin = System.nanoTime();
        lTotTime= lFin-lIni;
        System.out.println("Tardo: "+ lTotTime+" Nanosegundos");
        imprimirArreglo(aiPrueba4);
        
        
    }
    //SELECTION SORT
    public static void selectionSort(int[] aiDatos){//Lista en desorden
        for (int i = 0; i < aiDatos.length; i++) {
            int iMin=i;
            //Marcar la posicion del mas pequeño
            for (int j = i+1; j < aiDatos.length; j++) {
                if(aiDatos[j]<aiDatos[iMin])
                    iMin = j;
            }
            //INTERCAMBIAR CON LA PRIMER POSICION DE LA LISTA EN DESORDEN
            int iTemp = aiDatos[iMin];
            aiDatos[iMin] = aiDatos[i];
            aiDatos[i] = iTemp;
        }
    }
    
    //INSERTIONSORT
    public static int[] insertionSort(int[] aiDatos){
        int temp;
        for (int i = 1; i < aiDatos.length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(aiDatos[j] < aiDatos[j-1]){
                    temp = aiDatos[j];
                    aiDatos[j] = aiDatos[j-1];
                    aiDatos[j-1] = temp;
                }
            }
        }
        return aiDatos;
    }

    //BUBBLESORT
    public static void bubbleSort(int[] aiDatos){
        int n = aiDatos.length;
        int k;
        for (int m = n; m >= 0; m--) {
            for (int i = 0; i < n - 1; i++) {
                k = i + 1;
                if (aiDatos[i] > aiDatos[k]) {
                    swapNumbers(i, k, aiDatos);
                }
            }
        }
    }
    //QUICKSORT
    public static void quickSort (int aiLista[], int iIzq, int iDer){
    int i=iIzq;
    int j=iDer;
    int iPivote=aiLista[(i+j)/2];
    do {
        while (aiLista[i]<iPivote){
            i++;
        }
        while (aiLista[j]>iPivote){
            j--;
        }
        if (i<=j){
            int aux=aiLista[i];
            aiLista[i]=aiLista[j];
            aiLista[j]=aux;
            i++;
            j--;
        }
    }while(i<=j);
    if (iIzq<j){
        quickSort(aiLista, iIzq, j);
    }
    if (i<iDer){
        quickSort(aiLista, i, iDer);
    }
}
    public static void swapNumbers(int i, int j, int[] aiDatos) {
  
        int temp;
        temp = aiDatos[i];
        aiDatos[i] = aiDatos[j];
        aiDatos[j] = temp;
    }

        public static void imprimirArreglo(int[] aiDatos){
        for (int i = 0; i < aiDatos.length; i++) {
            System.out.print("["+aiDatos[i]+"]");
        }
        System.out.println("\n----------------------------------------------");
    }
}
