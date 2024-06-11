package 탐색;

/**
 * https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/
 * 1011 / Capacity To Ship Packages Within D Days
 *
 * A conveyor belt has packages that must be shipped from one port to another within days days.
 * The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.
 * Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within days days.
 *
 * Example 1:
 * Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
 * Output: 15
 * Explanation: A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
 * 1st day: 1, 2, 3, 4, 5
 * 2nd day: 6, 7
 * 3rd day: 8
 * 4th day: 9
 * 5th day: 10
 * Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.

 * Example 2:
 * Input: weights = [3,2,2,4,1,4], days = 3
 * Output: 6
 * Explanation: A ship capacity of 6 is the minimum to ship all the packages in 3 days like this:
 * 1st day: 3, 2
 * 2nd day: 2, 4
 * 3rd day: 1, 4

 * Example 3:
 * Input: weights = [1,2,3,1,1], days = 4
 * Output: 3
 * Explanation:
 * 1st day: 1
 * 2nd day: 2
 * 3rd day: 3
 * 4th day: 1, 1
 */
public class 이분탐색_배송최소용량_1011 {
    public static void main(String[] args) {
        int[] weights = new int[]{1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        System.out.println(shipWithinDays(weights, days));
    }

    public static int shipWithinDays(int[] weights, int days) {
        int maxWeight = 0;  // 배열 내 최대 무게 저장
        int sumWeight = 0;  // 배열 내 모든 무게 합 저장
        for (int weight : weights) {
            maxWeight = Math.max(maxWeight, weight);
            sumWeight += weight;
        }
        int left = maxWeight; // 가능한 최소 용량
        int right = sumWeight; // 가능한 최대 용량

        // 이진 탐색 시작
        while (left < right) {
            int mid = (left + right) / 2;
            // 현재 mid 용량으로 D일 안에 배송이 가능한지 확인
            if (canShip(weights, days, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * 주어진 'capacity' 용량으로 'weights' 배열의 모든 패키지를 'D' 일 안에 배송할 수 있는지 여부를 반환합니다.
     * @param weights 무게 배열
     * @param D 일수
     * @param capacity 용량
     * @return true: 배송 가능, false: 배송 불가능
     */
    private static boolean canShip(int[] weights, int D, int capacity) {
        int days = 1;   // 배송에 필요한 일수 계산
        int total = 0;  // 현재까지 배송한 무게의 합 저장
        for (int weight : weights) {
            total += weight;
            // 만약 total이 capacity를 초과하면 다음날로 넘어가고 total을 현재 패키지 무게로 초기화
            if (total > capacity) {
                total = weight;
                days++;
                // 만약 days가 D를 초과하면 현재 capacity로는 모든 패키지를 배송할 수 없으므로 false 반환
                if (days > D) {
                    return false;
                }
            }
        }
        return true;
    }

}

/*
주어진 배열의 항목들을 D일 안에 배송할 수 있는 최소 용량의 배를 찾는 문제입니다. 이 문제는 **이진 탐색(Binary Search)** 알고리즘을 사용하여 효율적으로 해결할 수 있습니다. 문제의 핵심은 가능한 최소 용량과 최대 용량 사이에서 올바른 용량을 찾는 것입니다.
- 주어진 배열 **`weights`**는 N개의 양의 정수로 구성되며, 각 정수는 항목의 무게를 나타냅니다.
- 양의 정수 D는 배가 모든 항목을 배송해야 하는 일수를 나타냅니다.
- 배의 용량은 하루에 배송할 수 있는 최대 무게를 의미합니다.
- 배열의 순서대로 항목을 배송해야 하며, 하루에 배송할 수 있는 총 무게는 배의 용량을 초과할 수 없습니다.

이 문제를 해결하기 위한 접근 방법은 다음과 같습니다:
1. **최소 용량과 최대 용량 결정**: 최소 용량은 배열 **`weights`**의 최대값으로 설정하고, 최대 용량은 배열의 모든 항목의 합으로 설정합니다.
2. **이진 탐색 실행**: 최소 용량과 최대 용량 사이에서 중간값을 용량으로 설정하고, 해당 용량으로 D일 안에 모든 항목을 배송할 수 있는지 확인합니다.
3. **조건 검사**: 만약 D일 안에 배송이 가능하다면, 용량을 줄여서 다시 검사합니다. 만약 불가능하다면, 용량을 늘려서 다시 검사합니다.
4. **최적의 용량 찾기**: 가능한 최소 용량을 찾을 때까지 2와 3의 과정을 반복합니다.
 */