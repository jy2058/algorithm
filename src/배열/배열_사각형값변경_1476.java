package 배열;

/**
 * https://leetcode.com/problems/subrectangle-queries/description/
 * 1476 / Subrectangle Queries
 *
 * Implement the class SubrectangleQueries which receives a rows x cols rectangle as a matrix of integers in the constructor and supports two methods:
 * 1. updateSubrectangle(int row1, int col1, int row2, int col2, int newValue)
 * Updates all values with newValue in the subrectangle whose upper left coordinate is (row1,col1) and bottom right coordinate is (row2,col2).
 * 2. getValue(int row, int col)
 * Returns the current value of the coordinate (row,col) from the rectangle.
 *
 * Example 1:
 * Input
 * ["SubrectangleQueries","getValue","updateSubrectangle","getValue","getValue","updateSubrectangle","getValue","getValue"]
 * [[[[1,2,1],[4,3,4],[3,2,1],[1,1,1]]],[0,2],[0,0,3,2,5],[0,2],[3,1],[3,0,3,2,10],[3,1],[0,2]]
 * Output
 * [null,1,null,5,5,null,10,5]
 * Explanation
 * SubrectangleQueries subrectangleQueries = new SubrectangleQueries([[1,2,1],[4,3,4],[3,2,1],[1,1,1]]);
 * // The initial rectangle (4x3) looks like:
 * // 1 2 1
 * // 4 3 4
 * // 3 2 1
 * // 1 1 1
 * subrectangleQueries.getValue(0, 2); // return 1
 * subrectangleQueries.updateSubrectangle(0, 0, 3, 2, 5);
 * // After this update the rectangle looks like:
 * // 5 5 5
 * // 5 5 5
 * // 5 5 5
 * // 5 5 5
 * subrectangleQueries.getValue(0, 2); // return 5
 * subrectangleQueries.getValue(3, 1); // return 5
 * subrectangleQueries.updateSubrectangle(3, 0, 3, 2, 10);
 * // After this update the rectangle looks like:
 * // 5   5   5
 * // 5   5   5
 * // 5   5   5
 * // 10  10  10
 * subrectangleQueries.getValue(3, 1); // return 10
 * subrectangleQueries.getValue(0, 2); // return 5

 * Example 2:
 * Input
 * ["SubrectangleQueries","getValue","updateSubrectangle","getValue","getValue","updateSubrectangle","getValue"]
 * [[[[1,1,1],[2,2,2],[3,3,3]]],[0,0],[0,0,2,2,100],[0,0],[2,2],[1,1,2,2,20],[2,2]]
 * Output
 * [null,1,null,100,100,null,20]
 * Explanation
 * SubrectangleQueries subrectangleQueries = new SubrectangleQueries([[1,1,1],[2,2,2],[3,3,3]]);
 * subrectangleQueries.getValue(0, 0); // return 1
 * subrectangleQueries.updateSubrectangle(0, 0, 2, 2, 100);
 * subrectangleQueries.getValue(0, 0); // return 100
 * subrectangleQueries.getValue(2, 2); // return 100
 * subrectangleQueries.updateSubrectangle(1, 1, 2, 2, 20);
 * subrectangleQueries.getValue(2, 2); // return 20
 */
public class 배열_사각형값변경_1476 {
    public static void main(String[] args) {
        int[][] rectangle = {
                {1, 2, 1},
                {4, 3, 4},
                {3, 2, 1},
                {1, 1, 1}
        };

        SubrectangleQueries obj = new SubrectangleQueries(rectangle);

        obj.getValue(0, 2);
        obj.updateSubrectangle(0, 0, 3, 2, 5);
        obj.getValue(0, 2);
        obj.getValue(3, 1);
        obj.updateSubrectangle(3, 0, 3, 2, 10);
        obj.getValue(3, 1);
        obj.getValue(0, 2);

        for (int[] row : obj.rectangle) {
            for (int val : row) {
                System.out.println(val + " ");
            }
            System.out.println();

        }
    }

    public static class SubrectangleQueries {
        private int[][] rectangle;

        // rectangle 초기화
        public SubrectangleQueries(int[][] rectangle) {
            this.rectangle = rectangle;
        }

        /**
         * 2차원 배열의 특정부분 영역을 새로운 값으로 변경
         * @param row1 영역시작 행
         * @param col1 영역시작 열
         * @param row2 영영끝 행
         * @param col2  영역끝 열
         * @param newValue  변경 값
         */
        public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
            // 영역의 시작부터 끝까지 새로운 값으로 변경
            for (int row = row1; row <= row2; row++) {
                for (int col = col1; col <= col2; col++) {
                    rectangle[row][col] = newValue;
                }
            }

        }

        /**
         * 입력위치의 값 리턴
         * @param row 행
         * @param col 열
         * @return 해당 배열 값
         */
        public int getValue(int row, int col) {
            return rectangle[row][col];
        }
    }
}

/*
이 문제는 2차원 배열 내에서 주어진 좌표에 따라 subrectangle 영역의 모든 값을 새로운 값으로 업데이트하고, 특정 위치의 값을 리턴하는 문제입니다.

1. 생성자 설정
2. 2차원 배열의 특정부분 영역을 새로운 값으로 변경
3. 2차원 배열의 특정부분 값 리턴
 */


