using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.IO.Ports;  //Подключение библиотеки для работы с последовательным портом COM1-COM16
using System.IO;
namespace Serial_port_test
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        SerialPort port;    //создание объекта

        private void Form1_Load(object sender, EventArgs e)
        {
            label1.Text = "";
            comboBox2.SelectedIndex = 0;
        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            try { port = new SerialPort(comboBox1.SelectedItem.ToString()); }   //инициализация объекта port
            catch (Exception) { 
                label1.Text = "Ошибка при создании объекта.";
                File.AppendAllText("E:\\new.txt", "Ошибка при создании объекта\r\n");
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            string finalText = "asda";
            DialogResult result;

            
            try
            {
                if (comboBox1.SelectedItem == null) { 
                    //label1.Text = "Не выбран порт.";
                    finalText = "Не выбран порт.";
                    File.AppendAllText("E:\\new.txt", "Не выбран порт." + "\r\n");
                    return;
                }
                label1.Text = "";
                textBox2.Text = "";
                port.ReadTimeout = 500; //таймаут на прием-передачу
                port.WriteTimeout = 500;
                port.Open();
                if (comboBox2.SelectedIndex == 0)
                {
                    port.WriteLine(textBox1.Text);
                    textBox2.AppendText(port.ReadLine());
                    File.AppendAllText("E:\\new.txt", "Information from port: " + textBox1.Text + "\r\n");
                }
                if (comboBox2.SelectedIndex == 1)
                {
                    port.RtsEnable = false;
                    textBox1.Text = "False" + Environment.NewLine;
                    textBox2.Text = port.CtsHolding.ToString() + Environment.NewLine;
                    port.RtsEnable = true;
                    textBox1.Text += "True";
                    textBox2.Text += port.CtsHolding.ToString();
                }
                if (comboBox2.SelectedIndex == 2)
                {
                    port.DtrEnable = false;
                    textBox1.Text = "False" + Environment.NewLine;
                    textBox2.Text = port.DsrHolding.ToString() + Environment.NewLine;
                    port.DtrEnable = true;
                    textBox1.Text += "True";
                    textBox2.Text += port.DsrHolding.ToString();
                }
                port.Close();
            }
            catch (ArgumentNullException)
            {
                //label1.Text = "Параметр str имеет значение null.";
                finalText = "Параметр str имеет значение null.";
                File.AppendAllText("E:\\new.txt", "Параметр str имеет значение null.\r\n");
            }
            catch (InvalidOperationException)
            {
                //label1.Text = "Указанный порт не открыт.";
                finalText = "Указанный порт не открыт.";
                File.AppendAllText("E:\\new.txt", "Указанный порт не открыт.\r\n");
            }
            catch (TimeoutException)
            {
                //label1.Text = "Операция не была завершена до истечения срока ожидания.";
                finalText = "Операция не была завершена до истечения срока ожидания.";
                File.AppendAllText("E:\\new.txt", "Операция не была завершена до истечения срока ожидания.\r\n");
            }
            catch (Exception)
            {
                //label1.Text = "Неизвестная ошибка.";
                finalText = "Неизвестная ошибка.";
                File.AppendAllText("E:\\new.txt", "Неизвестная ошибка.\r\n");
            }
            finally //закрытие порта
            {
                try { port.Close(); }
                catch (Exception) { }
                result = MessageBox.Show(finalText);
            }




            result = MessageBox.Show(finalText);
        
        
        }






        private void comboBox1_Click(object sender, EventArgs e)
        {
            label1.Text = "";
            try
            {
                comboBox1.Items.Clear();
                comboBox1.Items.AddRange(SerialPort.GetPortNames());
            }
            catch (Exception) { label1.Text = "Ошибка инициализации.";
                File.AppendAllText("E:\\new.txt", "Ошибка инициализации.\r\n");
            }
        }
    }
}
