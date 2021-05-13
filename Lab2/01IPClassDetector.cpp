#include<bits/stdc++.h>

using namespace std;


void findParam2(char str[], char ipClass);
char findParam1(char str[]);

int main()
{
	char str[16] ;
    cin>>str;
    
	char ipClass = findParam1(str);
	cout<<"\n";
	cout<<"In reference to the IP: "<<str<<"\n";
    cout<<"-------------------------------------"<<"\n";
    cout<<"Following are the discerned parameters: "<<"\n";
    cout<<"-------------------------------------"<<"\n";
    cout<<"| "<<"CLASS      -> "<<ipClass<<"                   |"<<"\n";
    
    findParam2(str, ipClass);
    cout<<"-------------------------------------"<<"\n";
	return 0;
}

void findParam2(char str[], char ipClass)
{
	// Initializing network and host array to NULL
	char network[12], host[12];
	for (int k = 0; k < 12; k++)
		network[k] = host[k] = '\0';

	// for class A, only first octet is Network ID
	// and rest are Host ID
	if (ipClass == 'A')
	{
		int i = 0, j = 0;
		while (str[j] != '.')
			network[i++] = str[j++];
		i = 0;
		j++;
		while (str[j] != '\0')
			host[i++] = str[j++];
		printf("Network ID is %s\n", network);
		printf("Host ID is %s\n", host);
	}

	// for class B, first two octet are Network ID
	// and rest are Host ID
	else if (ipClass == 'B')
	{
		int i = 0, j = 0, dotCount = 0;

		// storing in network[] up to 2nd dot
		// dotCount keeps track of number of
		// dots or octets passed
		while (dotCount < 2)
		{
			network[i++] = str[j++];
			if (str[j] == '.')
				dotCount++;
		}
		i = 0;
		j++;

		while (str[j] != '\0')
			host[i++] = str[j++];

        cout<<"| "<<"NETWORK ID -> "<<network<<"          |"<<"\n";
        cout<<"| "<<"HOST ID    -> "<<host<<"                  |"<<"\n";
	}

	else if (ipClass == 'C')
	{
		int i = 0, j = 0, dotCount = 0;

		while (dotCount < 3)
		{
			network[i++] = str[j++];
			if (str[j] == '.')
				dotCount++;
		}

		i = 0;
		j++;

		while (str[j] != '\0')
			host[i++] = str[j++];
        cout<<"| "<<"NETWORK ID -> "<<network<<"          |"<<"\n";
        cout<<"| "<<"HOST ID    -> "<<host<<"                  |"<<"\n";
        
	}

	else
        cout<<"Not valid partitioning under the class";
}


char findParam1(char str[])
{
	
	char arr[4];
	int i = 0;
	while (str[i] != '.')
	{
		arr[i] = str[i];
		i++;
	}
	i--;
	int ip = 0, j = 1;
	while (i >= 0)
	{
		ip = ip + (str[i] - '0') * j;
		j = j * 10;
		i--;
	}

	// Class A
	if (ip >=1 && ip <= 126)
		return 'A';

	// Class B
	else if (ip >= 128 && ip <= 191)
		return 'B';

	// Class C
	else if (ip >= 192 && ip <= 223)
		return 'C';

	// Class D
	else if (ip >= 224 && ip <= 239)
		return 'D';

	// Class E
	else
		return 'E';
}