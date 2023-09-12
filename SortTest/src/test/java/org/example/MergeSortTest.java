package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class MergeSortTest {

    @Test
    @DisplayName("Проверяет базовую функциональность с несортированными элементами")
    public void testMergeSort() {
        int[] inputArray = {12, 6, 4, 1, 15, 10};
        int[] sortedArray = {1, 4, 6, 10, 12, 15};
        Assertions.assertArrayEquals(sortedArray, MergeSort.mergeSort(inputArray));
    }

    @Test
    @DisplayName("Проверяет сортировку пустого массива")
    public void testEmptyArray() {
        int[] inputArray = {};
        int[] sortedArray = {};
        Assertions.assertArrayEquals(sortedArray, MergeSort.mergeSort(inputArray));
    }

    @Test
    @DisplayName("Проверяет сортировку массива только с одним элементом")
    public void testSingleElementArray() {
        int[] inputArray = {5};
        int[] sortedArray = {5};
        Assertions.assertArrayEquals(sortedArray, MergeSort.mergeSort(inputArray));
    }

    @Test
    @DisplayName("Тестирует сортировку отсортированного массива")
    public void testAlreadySortedArray() {
        int[] inputArray = {1, 2, 3, 4, 5};
        int[] sortedArray = {1, 2, 3, 4, 5};
        Assertions.assertArrayEquals(sortedArray, MergeSort.mergeSort(inputArray));
    }

    @Test
    @DisplayName("Tестирует сортировку массива, отсортированного в обратном порядке.")
    public void testReverseSortedArray() {
        int[] inputArray = {5, 4, 3, 2, 1};
        int[] sortedArray = {1, 2, 3, 4, 5};
        Assertions.assertArrayEquals(sortedArray, MergeSort.mergeSort(inputArray));
    }

    @Test
    @DisplayName("Проверяет сортировку массива с повторяющимися элементами")
    public void testArrayWithDuplicates() {
        int[] inputArray = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        int[] sortedArray = {1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9};
        Assertions.assertArrayEquals(sortedArray, MergeSort.mergeSort(inputArray));
    }

}

