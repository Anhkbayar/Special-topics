#include <catch2/catch_test_macros.hpp>
#include "../src/main.h"

TEST_CASE("Zuv daraalald oruulah") {
    int arr[] = {5,8,1,4,6};
    int n = 5;

    insertionSort(arr, n);

    REQUIRE(arr[0] == 1);
    REQUIRE(arr[1] == 4);
    REQUIRE(arr[2] == 5);
    REQUIRE(arr[3] == 6);
    REQUIRE(arr[4] == 8);
}

TEST_CASE("Zuv daraalaltai yed daraalal uurchlugduhgui") {
    int arr[] = {1, 2, 3, 4};
    insertionSort(arr, 4);

    REQUIRE(arr[0] == 1);
    REQUIRE(arr[1] == 2);
    REQUIRE(arr[2] == 3);
    REQUIRE(arr[3] == 4);
}
