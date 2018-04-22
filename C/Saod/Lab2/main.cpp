#include <iostream>
#include <cstring>
#include <fstream>
#include <iomanip>

using namespace std;

struct Student{
    char surname[15];
    char initials[4];
    int groupNumber;
    int progress[5];
    string toString(){
        string outer;
        char str[80];
        sprintf(str,"%-10s%-10s\t| %-5d |\t",surname,initials,groupNumber);
        outer = str;
        for (int progres : progress) {
            outer += to_string(progres) + " ";
        }
        outer += "|\n";
        return outer;
    }
};
Student students[10];
void menu();
string readFromFile();
void writeToFile();
void sortByGroupNumber();
void addStudent();
void printGoodStudents();
int studentsCount = 0;
int main(void){
    menu();
}
void menu(){
    char choice;
    while(true){
        cout<<"Choose something: \n\t1 - Create student info\n\t2 - Print all students\n\t3 - Read from file\n\t4 - Save to file"
                "\n\t5 - Sort students by group number\n\t6 - Print students who have average mark at least 4"<<endl;
        cin>>choice;
        switch (choice){
            case '1': addStudent();
                break;
            case '2':
                for (int i = 0; i < studentsCount; ++i) {
                    cout<<students[i].toString()<<endl;
                }
                break;
            case '3':cout<<readFromFile()<<endl;
                break;
            case '4':writeToFile();
                break;
            case '5':sortByGroupNumber();
                break;
            case '6': printGoodStudents();
                break;
            default:
                return;
        }
    }
}
void addStudent(){
    cout<<"Surname: ";
    cin>>students[studentsCount].surname;
    cout<<"Initials: ";
    cin>>students[studentsCount].initials;
    cout<<"Group number: ";
    cin>>students[studentsCount].groupNumber;
    cout<<"Marks(enter after mark): \n";
    for (int &progress : students[studentsCount].progress) {
        cin>> progress;
    }
    cout<<"Student successfully added"<<endl;
    cout<<students[studentsCount].toString()<<endl;
    studentsCount++;
    if (studentsCount > 9){
        writeToFile();
        studentsCount = 0;
    }
}
void writeToFile(){
    ofstream fileStream;
    fileStream.open("student1.txt", ios::app);
    for (int i = 0; i < studentsCount; i++) {
        fileStream << students[i].toString();
    }
    cout<<"Successfully wrote"<<endl;
    fileStream.close();
}
string readFromFile(){
    ifstream fileReader("student1.txt");
    string outStr;
    string tempStr;
    while (getline(fileReader,tempStr)){
        outStr += tempStr + "\n";
    }
    return outStr;
}
void sortByGroupNumber(){
    Student temp;
    for (int i = 0; i < studentsCount; i++) {
        for (int j = 0; j < studentsCount - i - 1; j++) {
            if (students[j].groupNumber > students[j + 1].groupNumber) {
                temp = students[j];
                students[j] = students[j + 1];
                students[j + 1] = temp;
            }
        }
    }
}
void printGoodStudents(){
    int goodStudents = 0;
    for (int i = 0; i < studentsCount; ++i) {
        double mark=0;
        for (int j = 0; j < 5; ++j) {
            mark += students[i].progress[j];
        }
        mark /= 5;
        if (mark > 4){
            cout<<students[i].toString()<<" Average mark: "<<mark<<endl;
            goodStudents++;
        }
    }
    if (goodStudents==0){
        cout<<"All students have low average mark(<4)"<<endl;
    }
}