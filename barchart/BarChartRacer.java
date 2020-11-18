import java.util.Arrays;

public class BarChartRacer {
    public static void main(String[] args) {

        String filename = args[0];
        int k = Integer.parseInt(args[1]);

        In file = new In(filename);

        String title = file.readLine();
        String xAxis = file.readLine();
        String source = file.readLine();
        BarChart chart = new BarChart(title, xAxis, source);


        String s;
        //draw the bar chart
        StdDraw.setCanvasSize(1000, 700);
        StdDraw.enableDoubleBuffering();


        String caption = "";

        while (file.hasNextLine()) {
            s = file.readLine();
            if (!s.isEmpty()) {
                int n = Integer.parseInt(s);
                Bar[] bars = new Bar[n];

                for (int i = 0; i < n; i++) {
                    s = file.readLine();
                    String[] arr = s.split(",");
                    if (i == 0) {
                        caption = arr[0];
                        chart.setCaption(arr[0]);
                    }
                    bars[i] = new Bar(arr[1], Integer.parseInt(arr[3]), arr[4]);
                }

                Arrays.sort(bars);
                chart.reset();
                for (int j = n - 1; j >= n - k; j--) {
                    chart.add(bars[j].getName(), bars[j].getValue(), bars[j].getCategory());
                }

                //draw the bar chart
                StdDraw.clear();
                chart.setCaption(caption);
                chart.draw();
                StdDraw.show();
                StdDraw.pause(10);
            }
        }
    }
}
