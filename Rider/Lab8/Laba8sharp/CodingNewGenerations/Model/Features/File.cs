using System;
using System.IO;
using System.Text;
using Laba8sharp.CodingNewGenerations.Model.Entity.Container;

namespace Laba8sharp.CodingNewGenerations.Model.Features
{
    public class File
    {
        public static void WriteInFile(string tree,string filename)
        {
            try
            {
                StreamWriter writer = new StreamWriter(filename,true);
                writer.WriteLine(tree);
                writer.Close();
            }
            catch (IOException)
            {
                return;
            }
        }

        public static String ReadFile(string fileName)
        {
            StreamReader reader = new StreamReader(fileName);
            StringBuilder sb = new StringBuilder();
            string line;
            while ((line = reader.ReadLine()) != null)
            {
                sb.Append(line).Append("\n");
            }
            return sb.ToString();

        }

        public static void WriteInHtml(Tree tree)
        {
            try{
                string firstHalf = "<!DOCTYPE html>\n" + "<html lang=\"en\">\n" + "<head>\n" + "    <meta charset=\"UTF-8\">\n" + "    <title>Title</title>\n" + "</head>\n" + "<body>\n";
                string middle = tree.ToString();
                string secondHalf = "\n" + "</body>\n" + "</html>";
                string all = firstHalf + middle + secondHalf;
                WriteInFile(all,"Example.html");
                

            } catch (IOException e) {
                return;
            }
        }
        
    }
}