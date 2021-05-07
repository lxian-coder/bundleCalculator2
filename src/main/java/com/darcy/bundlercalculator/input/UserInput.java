package com.darcy.bundlercalculator.input;

import lombok.RequiredArgsConstructor;

import java.util.*;

/**
 * Darcy Xian  4/5/21  4:48 pm      bundleCalculator
 */
@RequiredArgsConstructor
public class UserInput {
    private final Map<String, Map<String, String>> bundlesFormatMap;

    public List<String> getInputData() {
        boolean checkResult = false;
        List<String> inputList = new ArrayList<>();
        while (!checkResult) {
            inputList = scanDataFromConsole();
            checkResult = checkTheInput(inputList);
            if (checkResult) break;
        }
        return inputList;
    }

    private List<String> scanDataFromConsole() {
        System.out.println("Please input Data (case insensitive and double click Enter to finish input): ");
        Scanner s = new Scanner(System.in);
        int i = 0;
        StringBuilder inputString = new StringBuilder(" ");
        while (true) {
            i++;
            String line2 = s.nextLine().toLowerCase();
            inputString.append(" ").append(line2);
            if (line2.length() == 0 && i != 1) break;
        }
        List<String> inputList = new ArrayList<>(Arrays.asList(inputString.toString().split(" ")));
        inputList.removeAll(Collections.singletonList(""));
        return inputList;
    }

    private boolean checkTheInput(List<String> list) {
        int listSize = list.size();
        int dataSize = bundlesFormatMap.size();

        if (listSize % 2 != 0 || listSize > dataSize * 2) {
            System.out.println("Sorry, the format of your input is not correct. A legal order looks like:<Numbers of buddles> <formatcode> ");
            System.out.println("Please make an order again.");
            return false;
        }
        for (int i = 0; i < listSize; i++) {
            if (i % 2 == 0) {
                if (!isStrToNum(list.get(i))) {
                    System.out.println('"' + list.get(i) + '"' + " is not a number! Please check and input again!");
                    return false;
                }
            } else if (!bundlesFormatMap.containsKey(list.get(i))) {
                System.out.println('"' + list.get(i) + '"' + " is Not a format code! Please check and input again!");
                return false;
            }
        }
        return true;
    }

    private boolean isStrToNum(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
