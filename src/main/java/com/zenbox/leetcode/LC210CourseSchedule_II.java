package com.zenbox.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * {@code LC210CourseSchedule_II}
 * <p>
 * Solution for <a href="https://leetcode.com/problems/course-schedule-ii">210.
 * Course Schedule II</a>.
 * </p>
 */
public class LC210CourseSchedule_II {

    public static void main(String[] args) {
        LC210CourseSchedule_II.SolutionBFS a = new SolutionBFS();
        LC210CourseSchedule_II.SolutionDFS b = new SolutionDFS();
        int numCourses = 2;
        int[][] prerequisites = { { 0, 1 } };
        System.out.println(Arrays.toString(a.findOrder(numCourses, prerequisites)));
        System.out.println(Arrays.toString(b.findOrder(numCourses, prerequisites)));
    }

    static class SolutionDFS {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            List<List<Integer>> cons = new ArrayList<>();

            for (int i = 0; i < numCourses; i++) {
                cons.add(new ArrayList<>());
            }

            for (int[] u : prerequisites) {
                cons.get(u[1]).add(u[0]);
            }

            boolean[] visited = new boolean[numCourses];
            boolean[] path = new boolean[numCourses];
            List<Integer> res = new ArrayList<>();

            for (int i = 0; i < numCourses; i++) {
                if (!visited[i]) {
                    if (!dfs(i, cons, visited, path, res))
                        return new int[] {};
                }
            }

            Collections.reverse(res);

            int[] arr = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                arr[i] = res.get(i);
            }

            return arr;

        }

        private boolean dfs(int curr, List<List<Integer>> cons, boolean[] visited, boolean[] path, List<Integer> res) {
            visited[curr] = true;
            path[curr] = true;

            for (Integer u : cons.get(curr)) {
                if (!visited[u]) {
                    if (!dfs(u, cons, visited, path, res)) {
                        return false;
                    }
                } else if (path[u]) {
                    return false;
                }
            }

            res.add(curr);
            path[curr] = false;

            return true;
        }
    }

    static class SolutionBFS {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            List<List<Integer>> cons = new ArrayList<>();

            for (int i = 0; i < numCourses; i++) {
                cons.add(new ArrayList<>());
            }

            int[] inDegree = new int[numCourses];

            for (int[] u : prerequisites) {
                cons.get(u[1]).add(u[0]);
                inDegree[u[0]]++;
            }

            Queue<Integer> q = new LinkedList<>();

            for (int i = 0; i < numCourses; i++) {
                if (inDegree[i] == 0) {
                    q.add(i);
                }
            }

            int[] res = new int[numCourses];
            int idx = 0;
            while (!q.isEmpty()) {
                int c = q.poll();
                res[idx++] = c;

                for (int u : cons.get(c)) {
                    inDegree[u]--;
                    if (inDegree[u] == 0) {
                        q.add(u);
                    }
                }

            }

            if (idx < numCourses) {
                return new int[0];
            }

            return res;
        }
    }
}
