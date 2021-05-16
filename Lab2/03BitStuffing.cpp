#include<bits/stdc++.h>

using namespace std;

string bitStuff(string frame)
{
    int one = 0;
    string temp = "";
    for(int i=0;i<frame.size();i++)
    {
        temp += frame[i];
        //cout<<temp<<"\n";
        if(frame[i]=='0')one=0;
        
        else if(frame[i]!='0')
        {
            one++;
            if(one==5){
                temp+="0";
                one =0;
            }
        }
    }
    return temp;
}

string bitDeStuff(string frame)
{
    int one = 0;
    string temp = "";
    for(int i=0;i<frame.size();i++)
    {
        temp += frame[i];
        if(frame[i]=='0')one=0;
        else if (frame[i]!='0')
        {
            one++;
            if(one==5){
                i++;
                one =0;
            }
        }
    }
    return temp;
}


int main(){
    cout<<"Enter the DATAFRAME: "<<"\n";
    string frame;
    cin>>frame;
    cout<<"BitStuffed: "<<bitStuff(frame)<<"\n";
    cout<<"BitDeStuffed: "<<bitDeStuff(frame)<<"\n";
}
