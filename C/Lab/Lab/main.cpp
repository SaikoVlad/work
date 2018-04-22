#include <iostream>
using namespace std;


int menu() // Меню 
{ 
	cout << "Выберите:" << endl; 
	cout << "1. Ввести имя файла" << endl; 
	cout << "2. Новый файл" << endl; 
	cout << "3. Ввести файл" << endl; 
	cout << "4. Открыть файл" << endl; 
	cout << "5. Вывести результат" << endl; 
	cout << "6. Вывести в файл" << endl; 
	cout << "7. Выход" << endl; 
	int i; 
	cin >> i; 
	return i; 
} 
void namef() // Ввести имя файла 
{ 
	string name;
	cout << "Введите имя файла" << endl; 
	cin >> name; 
} 
void newf() // Создать новый файл 
{ 
	FILE * fl;
	//str
	if ((fl = fopen(name, "wb")) == NULL) 
	{ 
		cout << "Ошибка при создании!" << endl; 
		exit(1); 
	} 
	cout << "OK" << endl; 
	fclose(fl); 
} 
void spisok() // Ввести список 
{ 
	if ((fl = fopen(name, "rb+")) == NULL) 
	{ 
		cout << "Ошибка при создании!" << endl; 
		exit(1); 
	} 
	cout << "Введите число абонентов: " << endl; 
	cin >> n; 
	for (int i = 0; i < n; i++) 
	{ 
		cout << "Введите номер: "; 
		cin >> mats[i].nomer; 
		cout << "Введите время разговора в секундах: "; 
		cin >> mats[i].time; 
		cout << "Введите тариф: "; 
		cin >> mats[i].tarif 
		; 
		fwrite(&mats[i], sizeof(TMats), 1, fl); 
	} 
	fclose(fl); 
} 
void opf() // Открыть файл 
{ 
	if ((fl = fopen(name, "rb")) == NULL) 
	{ 
		cout << "Ошибка при открытии!" << endl; 
		exit(1); 
	} 
	int n = 0; 
	TMats std; 
	while (true) 
	{ 
	int nwrt = fread(&std, sizeof(TMats), 1, fl); 
	if (nwrt != 1) break; 
	mats[n] = std; 
	cout << mats[n].time << " " << mats[n].time 
	<< " " << mats[n].time << endl; 
	n++; 
	} 
	fclose(fl); 
} 

void resc() // Вывести результат на экран 
{ 
	int i, sum, stime = 0, ssum = 0; 
	char nameg[100]; 
	for (i = 0; i < n; i++) 
	{ 
		if (nameg == mats[i].nomer) 
		{ 
		stime = stime + mats[i].time; 
		sum = mats[i].time*mats[i].tarif; 
		} 
		cout << endl << "Сумма абонента: " << i << ":" << sum << endl; 
	} 
} 
void resf() // Вывести результат в файл 
{ 
	char namet[30]; 
	FILE *ft; 
	cout << "Введите имя файла:" << endl; 
	cin >> namet; 
	if ((ft = fopen(namet, "w")) == NULL) 
	{ 
	cout << "Ошибка при создании! " << endl; 
	exit(1); 
	} 
	string out= "";
	char s[80]; 
	for (int i = 0; i<n; i++) 
	{ 
		out += (s + "\n");
		//strcat(s, "\n"); // Добавление разделителя строк 
		fputs(s, ft); 
	} 
	fclose(ft); 
	system("pause"); 

}

int main (int argc, char *argv[])
{
	cout << "Hello world!" << endl;
	setlocale(LC_ALL, "rus"); // Устанавливает русский язык 

	while (true) 
	{ 
	switch (menu()) 
	{ 
		case 1: namef(); break; 
		case 2: newf(); break; 
		case 3: spisok(); break; 
		case 4: opf(); break; 
		case 5: resc(); break; 
		case 6: resf(); break; 
		case 7: return 0; 
		default: "Выберите правильно!"; 
	} 
	puts("Нажмите любую кнопку,чтобы продолжить"); 
	getchar(); system("cls"); 
	} 

	return 0;
}
