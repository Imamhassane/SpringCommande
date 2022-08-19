const email = document.getElementById("email")
const password = document.getElementById("password")
const  form = document.getElementById("form")
////burger
const formBurger = document.getElementById("formBurger")
const nomBurger = document.getElementById("Le nom")
const prixBurger = document.getElementById("Le prix")
const descriptionBurger = document.getElementById("La description")
const fileInput = document.getElementById("L'image")
const sv = document.getElementById("suivant")
const nomMenu = document.getElementById("nom")
const Burger = document.getElementById("Le burger")
const DescriptionMenu = document.getElementById("La description du menu")
const Image = document.getElementById("Image")
////
const typeComp = document.getElementById("typeComp")
const tailleF = document.getElementById("La taille du fritte")
const tailleBoissonComp = document.getElementById("La taille du boisson")
const marque = document.getElementById("La marque")
const quantite = document.getElementById("La quantite")
const imgComplement = document.getElementById("l'image du complement")
const formComp = document.getElementById("formComp")
////
const checkboxBoisson = document.getElementsByClassName("checkboxBoisson")
////
let isVerify = []
//Functions-------------------------------------------------------------
function showError(input, message) {//Afficher les messages d'erreur
    const formControl = input.parentElement;
    formControl.classList.add("error");
    formControl.classList.remove("success");
    const small = formControl.querySelector('small');
    small.innerText = message;
    isVerify.push(false)
    return false
}
//
function showSuccess(input) {
    const formControl = input.parentElement;
    formControl.classList.add("success");
    formControl.classList.remove("error");
    isVerify.push(true)
    return true;
}

function checkLength(input, min, max) {//Tester la longueur de la valeur  d'un input
    if(input.value.length < min){
        showError(input, `${getFieldName(input)} doit contenir au moins ${min} caractéres!`)
        return false
    }else if(input.value.length > max){
        showError(input, `${getFieldName(input)} doit contenir au plus ${max} caractéres !`);
        return false
    }else{
        showSuccess(input);
        return true;
    }
}


//
function checkRequired(inputArray) {// Tester si les champs ne sont pas vides
    inputArray.forEach(input => {
        if (input.value.trim() === '') {
            showError(input,`${getFieldName(input)} est obligatoire`);
        }else{
            showSuccess(input);
        }
    });
}


//
function checkEmail(input) {//Tester si l'email est valide :  javascript : valid email
    const re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

    if (re.test(input.value.trim().toLowerCase())) {
        showSuccess(input);
    } else {
        showError(input,`L'email n'est pas valide`);
    }
}
//
function imageValidation(params) {
    var filePath = params.value;
    var allowedExtensions = /(\.jpg|\.jpeg|\.png|\.gif)$/i;
    if(!allowedExtensions.exec(filePath)){
        fileInput.value = '';
        showError(params, `${getFieldName(params)} est obligatoire`);
        return false
    }else{
        showSuccess(params);
        return true
    }
}
//
function getFieldName(input) {//Retour le nom de chaque input en se basant sur son id
    return input.id.charAt(0).toUpperCase() + input.id.slice(1);
}
//
//Even listeners--------------------------------------------------------
if(form){
    form.addEventListener('submit',function(e){

        isVerify = []
        checkLength(password , 6 , 30);
        checkEmail(email);
        for (let i = 0; i < isVerify.length; i++) {
            if (isVerify[i]==false) {
                e.preventDefault();//Bloquer la soumission du formulaire
            }
        }

    });
}
if (formBurger){
    formBurger.addEventListener("submit" , (e)=>{

        isVerify = []
        checkLength(nomBurger , 3 , 30);
        checkLength(descriptionBurger , 50 , 255);
        checkRequired([prixBurger])
        imageValidation(fileInput)

///////////////////////////
        for (let i = 0; i < isVerify.length; i++) {
            if (isVerify[i]==false) {
                e.preventDefault();//Bloquer la soumission du formulaire
            }
        }
    })
}
///////////////////////////
if (typeComp){
    typeComp.addEventListener("change" , ()=>{
        if (typeComp.value == "fritte"){
            document.getElementById("boissondata").classList.remove("active")
            document.getElementById("frittesdata").classList.add("active")
        }else if (typeComp.value == "boisson"){
            document.getElementById("boissondata").classList.add("active")
            document.getElementById("frittesdata").classList.remove("active")
        }
    })
}
formComp.addEventListener("submit" , (e)=>{
    console.log(typeComp.value)
    isVerify = []
    if (typeComp.value == "boisson"){
        checkRequired([tailleBoissonComp, marque, quantite])
    }else if (typeComp.value == "fritte"){
        checkRequired([tailleF])
    }
    imageValidation(imgComplement)

    for (let i = 0; i < isVerify.length; i++) {
        if (isVerify[i]==false) {
            e.preventDefault();//Bloquer la soumission du formulaire
        }
    }
})