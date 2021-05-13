#include<bits/stdc++.h>

using namespace std;

void BinaryRep(int a);

int charArrToInt(const char* a)
{   
    int i=0;
    int an=0;
    string ans;
    for(;a[i]!='0';)
    {
        ans += a[i++];
    }
     an=stoi(ans);
     return an;
}

int main()
{
    int a,b,c,d;
    char dotIP[100];
    cin>>dotIP;

    char* ptr = strtok(dotIP,".");
    
    a = charArrToInt(ptr);

    ptr = strtok(NULL,".");
    b = charArrToInt(ptr);

    ptr = strtok(NULL,".");
    c = charArrToInt(ptr);

    ptr = strtok(NULL,".");
    d = charArrToInt(ptr);

    //cout<<"a "<<a<<endl;
    cout<<"\n"<<"Following is the BINARY REPRESENTATION for the given IP ADDRESS: "<<"\n";

    if((a>255||a<0)||(b>255||b<0)||(c>255||c<0)||(d>255||d<0))
    {
        cout<<"data error";
        return 0;
    }
    else
    {    BinaryRep(a);
         BinaryRep(b);
         BinaryRep(c);
         BinaryRep(d);
    }
    return 0;
}

void BinaryRep(int a)
{
    cout<<" ";
    int x[8]={0};
    int *p=x,n=0;//n is used to calculate the actual length of the binary number
    while(a!=0)
    {
        *p=a%2;
        p++;n++;
        a/=2;
    }
    if(p<x+7)
    {//If the binary number occupies less than 8 bits
        for(int i=n;i<8;i++)//Padded zero in front
            cout<<0;
        for(int i=n-1;i>=0;i--)//Reverse order output
            cout<<x[i];
    }
    else
        for(int i=7;i>=0;i--)
        cout<<x[i];
}