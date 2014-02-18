using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace LabGraph
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private const int pixelWidth = 15000;
        private const int pixelHeight = 7500;
        private const double dpiX = 96.0;
        private const double dpiY = 96.0;
        private WriteableBitmap graphBitMap = 
                new WriteableBitmap(pixelWidth, pixelHeight, dpiX, dpiY, PixelFormats.Gray8, null);
        //constructor
        public MainWindow()
        {
            InitializeComponent();
        }

        private void plotButton_Click(object sender, RoutedEventArgs e)
        {
            int stride = pixelWidth;
            int datasize = stride * pixelHeight;
            byte[] data = new byte[datasize];

            generateGraphData(data);
            graphBitMap.WritePixels(new Int32Rect(0,0,pixelWidth, pixelHeight), data, stride, 0);
            //graphImage.Source=graphBitMap;
        }

        private void generateGraphData(byte[] data)
        {
            int a = pixelWidth / 2;
            int b = a * a;
            int c = pixelHeight / 2;

            for (int x = 0; x < a; x++)
            {
                int s = x * x;
                double p = Math.Sqrt(b-s);
                for(double i = -p; i<p; i+=2)
                {
                    double r = Math.Sqrt(1.5 * s + i * i);
                    double q = (r - 1) * Math.Cos(25*r +25);
                    double y = i / 4 + (q * c);
                    drawXY(data, (-x+(pixelWidth/2)), (int)(y+(pixelHeight/2)));
                    drawXY(data, (x + (pixelWidth / 2)), (int)(y + (pixelHeight / 2)));
                }
            }
        }//end method
        private void drawXY(byte[] data, int x, int y)
        {
            data[x + y * pixelWidth] = 0xFF;
        }
    }//end class
}//end namespace
