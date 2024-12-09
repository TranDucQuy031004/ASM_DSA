package Asm2;

public class Graph {
    public static class GraphMatrix {
        private int[][] adjMatrix; // Mảng hai chiều lưu ma trận kề
        private int numVertices;  // Số đỉnh của đồ thị

        // Constructor để khởi tạo ma trận kề
        public GraphMatrix(int numVertices) {
            this.numVertices = numVertices;
            adjMatrix = new int[numVertices][numVertices]; // Khởi tạo ma trận kề kích thước V x V
        }

        // Thêm cạnh vào đồ thị
        public void addEdge(int i, int j) {
            adjMatrix[i][j] = 1; // Đánh dấu có cạnh từ i đến j
            adjMatrix[j][i] = 1; // Vì đồ thị vô hướng, thêm cạnh ngược lại
        }

        // Xóa cạnh khỏi đồ thị
        public void removeEdge(int i, int j) {
            adjMatrix[i][j] = 0; // Bỏ đánh dấu cạnh từ i đến j
            adjMatrix[j][i] = 0; // Vì đồ thị vô hướng, xóa cạnh ngược lại
        }

        // In ra ma trận kề
        public void printMatrix() {
            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    System.out.print(adjMatrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    public static class Main {
        public static void main(String[] args) {
            // Tạo đồ thị với 5 đỉnh
            GraphMatrix graph = new GraphMatrix(5);

            // Thêm các cạnh
            graph.addEdge(0, 1); // Cạnh từ 1 đến 2
            graph.addEdge(0, 2); // Cạnh từ 1 đến 3
            graph.addEdge(1, 2); // Cạnh từ 2 đến 3
            graph.addEdge(1, 3); // Cạnh từ 2 đến 4
            graph.addEdge(2, 4); // Cạnh từ 3 đến 5
            graph.addEdge(3, 4); // Cạnh từ 4 đến 5

            // In ra ma trận kề của đồ thị
            System.out.println("Ma trận kề của đồ thị:");
            graph.printMatrix();
        }
    }
}
