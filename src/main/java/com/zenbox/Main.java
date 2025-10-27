package com.zenbox;

import com.zenbox.leetcode.LC271EncodeAndDecodeStrings;

import java.util.*;

public class Main {

      public static void main(String[] args) {

          var coder = new LC271EncodeAndDecodeStrings();
          for (String[] testcase: LC271EncodeAndDecodeStrings.TEST_CASES) {
              System.out.println("====================");
              System.out.println("Testcase " + Arrays.toString(testcase));
              String encoded = coder.encode(List.of(testcase));
              System.out.println("Encoded " + encoded);
              System.out.println("Decoded " + coder.decode(encoded));
              System.out.println("====================");
          }
      }
}
