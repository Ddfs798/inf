package org.example;

import java.util.Arrays;

public class MergeSort {
    public static int[] mergeSort(int[] sortArr) {
        int[] buffer1 = Arrays.copyOf(sortArr, sortArr.length);
        int[] buffer2 = new int[sortArr.length];
        int[] result = mergeSortInner(buffer1, buffer2, 0, sortArr.length);
        return result;
    }

    /* Проверяет, нужно ли сортировать массив
       Если длина массива равна 1 или меньше, то массив уже отсортирован,
       поэтому метод возвращает его без изменений */
    public static int[] mergeSortInner(int[] buffer1, int[] buffer2, int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) {
            return buffer1;
        }

        // Вычисление середины подмассива
        int middle = (startIndex + endIndex) / 2;

        // Рекурсивный вызов метода для левой половины подмассива до середины
        int[] leftSorted = mergeSortInner(buffer1, buffer2, startIndex, middle);

        // Для правой половины подмассива от середины до конца
        int[] rightSorted = mergeSortInner(buffer1, buffer2, middle, endIndex);

        int leftIndex = startIndex;
        int rightIndex = middle;
        int destIndex = startIndex;

        /* Если левый подмассив уже был отсортирован и находится в buffer1, то результат сортировки будет
           записываться в buffer2. Иначе будет записываться в buffer1 */
        int[] result = leftSorted == buffer1 ? buffer2 : buffer1;


        // Цикл, который выполняется пока не достигнута граница левой или правой половины подмассива
        while (leftIndex < middle && rightIndex < endIndex) {
            result[destIndex++] = leftSorted[leftIndex] < rightSorted[rightIndex]
                    ? leftSorted[leftIndex++] : rightSorted[rightIndex++];
        }

        /* Добавляет оставшиеся элементы из левого массива,
           если они были пропущены в первом цикле */
        while (leftIndex < middle) {
            result[destIndex++] = leftSorted[leftIndex++];
        }

        /* Добавляет оставшиеся элементы из правого массива,
           если они были пропущены в первом цикле */
        while (rightIndex < endIndex) {
            result[destIndex++] = rightSorted[rightIndex++];
        }

        return result;
    }
}
