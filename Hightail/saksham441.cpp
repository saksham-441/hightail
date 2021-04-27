#include<bits/stdc++.h>
using namespace std;
#define ll long long int
#define pb push_back
#define take vll a(n);for (int i=0;i<n;i++){cin>>a[i];}
#define fast ios_base::sync_with_stdio(false);cin.tie(NULL)
#define endl "\n"
#define memory_of_node (struct node *)malloc(sizeof(struct node))
#define vll vector<long long int>
#define vpl vector<pair<ll,ll>>
#define mp make_pair
#define s second
#define f first
#define st(v) sort(v.begin(),v.end())
#define Y cout<<"YES"<<endl
#define N cout<<"NO"<<endl
#define SY cout<<"Yes"<<endl
#define SN cout<<"No"<<endl
#define rep(start,upto,increment) for(int j=start;j<upto;j+=increment)
#define sz(a) a.size()
ll vmax(vll v){
    ll max=v[0];
    ll j;
    for (j=0;j<v.size();j++){
        if (v[j]>max){
            max=v[j];
        }
    }
    return (max);
}
ll vmin(vll v){
    ll min=v[0];
    ll j;
    for (j=0;j<v.size();j++){
        if (v[j]<min){
            min=v[j];
        }
    }
    return (min);
}
void solve(){
    ll n;
    cin>>n;
    take;
    vll answer[n];
    rep(0,n,1){
        ll k;
        for (k=0;k<a.size();k++){
            answer[j].pb(a[k]);
        }
        ll min=a[0];
        ll i=0;
        rep(0,a.size(),1){
            if (min>a[j]){
                min=a[j];
                i=j;
            }
        }
        a.erase(a.begin()+i);
    }
    // rep(0,n,1){
    //     ll k;
    //     for (k=0;k<answer[j].size();k++){
    //         cout<<answer[j][k]<<" ";
    //     }
    //     cout<<endl;
    // }
    ll mat[n][n];
    memset(mat,0,sizeof(mat));
    rep(0,n,1){
        ll start=j;
        ll end=n-1-j;
        ll in=0;
       // cout<<start<<" "<<end<<endl;
        while (start<=n-1){
            mat[start][in]=answer[j][in];
            in++;
            start++;
        }
    }
    rep(0,n,1){
        ll k;
        for (k=0;k<n;k++){
            if (mat[j][k]!=0){
                cout<<mat[j][k]<<" ";
            }
        }
        cout<<endl;
    }

}
int main(){
    fast;
    ll t=1;
   // cin>>t;
    while (t--){
        solve();
    }
    return 0;
}