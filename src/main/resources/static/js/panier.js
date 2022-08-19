const addCart = document.getElementsByClassName("add-cart")
const compteur = document.getElementById("compteur")

let nbrCommande = 0
addInPanier();

function updateCompteur(params = null) {
    //recupérer le nombre de clic et l'afficher dans le compteur
    if (params == null) {
        nbrCommande++
    }else{
        nbrCommande -= params
    }
    compteur.style.display = "flex";
    compteur.innerHTML = nbrCommande;
    localStorage.setItem("nbrCommande" , nbrCommande);
}
//

function addInPanier(params) {
    for (let i = 0; i < addCart.length; i++) {
        addCart[i].addEventListener("click",(e)=>{//Evens
            updateCompteur();
        });
    }
}
//

//Rechargement de page
let currpage    = window.location.href;
let lasturl     = sessionStorage.getItem("last_url");

if(lasturl == null || lasturl.length === 0 || currpage !== lasturl ){
    update()

}else{
    update()
}

//recupérer le nombre de clic stocké dans la session et l'afficher dans le compteur
function update(params) {
    nbrCommande = localStorage.getItem("nbrCommande");
    //request
    if(nbrCommande > 0 ){
        //
        compteur.style.display = "flex";
        compteur.innerHTML = localStorage.getItem("nbrCommande");
    }else{
        compteur.style.display = "none";
    }
}
