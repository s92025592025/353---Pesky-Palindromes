#include <iostream>
#include <vector>
#include <algorithm>
#include <cctype> //used for toupper(int)
using namespace std;

int count(string vocab);
bool verify(string vocab);

int main(){
	string vocab;
	while(cin >> vocab){
		cout << "The string '" << vocab << "' contains " << count(vocab) << " palindromes." << endl;
	}

	return 0;
}

int count(string vocab){
	vector<string> list;
	for(int i = 1; i < vocab.length() + 1; i++){
		for(int s = 0; s < vocab.length() + 1 - i; s++){
			if(find(list.begin(), list.end(), vocab.substr(s, i)) == list.end() &&
				verify(vocab.substr(s, i))){
				list.push_back(vocab.substr(s, i));
			}
		}
	}

	return list.size();
}

bool verify(string vocab){
	for(int i = 0; i < vocab.length() / 2; i++){
		if(toupper(vocab[i]) != toupper(vocab[vocab.length() - 1 - i])){
			return false;
		}
	}

	return true;
}