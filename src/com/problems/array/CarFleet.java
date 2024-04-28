package com.problems.array;

import java.util.Arrays;

/*
 *
 * problem links :
 * https://leetcode.com/problems/car-fleet/
 *
 * Solution link :
 *
 * */
public class CarFleet {
    // TODO study later
    public static void main(String[] args) {
        type1();
        type2();
        type3();
    }

    private static void type3() {
        int target = 10;
        int[] position = {0, 4, 2};
        int[] speed = {2, 1, 3};
        int n = position.length;
        float[] time = new float[target];
        for (int i = 0; i < n; i++) {
            time[position[i]] = (float) (target - position[i]) / speed[i];
        }
        int fleet = 0;
        float maxTime = 0;
        for (int i = target - 1; i >= 0; i--) {
            if (time[i] > maxTime) {
                maxTime = time[i];
                fleet++;
            }
        }
        System.out.println(fleet);
    }

    private static void type2() {
        int target = 10;
        int[] position = {0, 4, 2};
        int[] speed = {2, 1, 3};
        int n = position.length;
        int fleet = 0;
        int maxPosition = Arrays.stream(position).max().getAsInt();
        float[] times = new float[maxPosition + 1];
        for (int i = 0; i < n; i++) times[position[i]] = (float) (target - position[i]) / speed[i];
        float prevVehicleTime = times[maxPosition];
        fleet++;
        for (int i = maxPosition - 1; i >= 0; i--) {
            if (times[i] > prevVehicleTime) {
                prevVehicleTime = times[i];
                fleet++;
            }
        }
        System.out.println(fleet);
    }

    private static void type1() {
        int target = 10;
        int[] position = {0, 4, 2};
        int[] speed = {2, 1, 3};
        int n = position.length;
        int[][] positions = new int[n][2];
        for (int i = 0; i < n; i++) {
            positions[i][0] = position[i];
            positions[i][1] = speed[i];
        }
        Arrays.sort(positions, (item1, item2) -> Integer.compare(item2[0], item1[0]));
        int fleet = 0;
        float currentVehicleTime;
        float prevVehicleTime = (float) (target - positions[0][0]) / positions[0][1];
        fleet++;
        for (int i = 1; i < n; i++) {
            currentVehicleTime = (float) (target - positions[i][0]) / positions[i][1];
            if (currentVehicleTime > prevVehicleTime) {
                prevVehicleTime = currentVehicleTime;
                fleet++;
            }
        }
        System.out.println(fleet);
    }

}
