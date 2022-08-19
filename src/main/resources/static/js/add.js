const addfood =  document.querySelectorAll(".addfood")

const complementForm = document.getElementById("complementForm")
const burgerForm = document.getElementById("burgerForm")
const menuForm = document.getElementById("menuForm")
const menu_class =  document.getElementsByClassName("menu_class")
let etape = 0
let nbr_form = menu_class.length
let precedent = document.querySelector('.precedent')
let suivant = document.querySelector('.suivant')



function removeForm(params){
    for (let i = 0; i < params.length ; i++) {
        params[i].classList.remove("active")
    }
}
addfood.forEach(function(element){
    element.addEventListener("click",()=>{
        removeForm(addfood)
        element.classList.add("active")
        let id = element.getAttribute("id")
        if (id === "menuFormbutton"){
            menuForm.classList.add("active")
            burgerForm.classList.remove("active")
            complementForm.classList.remove("active")
        }else if (id === "complementFormbutton"){
            menuForm.classList.remove("active")
            burgerForm.classList.remove("active")
            complementForm.classList.add("active")
        }else if (id === "burgerFormbutton"){
            menuForm.classList.remove("active")
            burgerForm.classList.add("active")
            complementForm.classList.remove("active")
        }
    })
});
/* menu form step*/
if (etape == 0){
    precedent.style.display="none"
}else if (etape > 0){
    precedent.style.display="block"}
function enleveclass() {
    for (let i = 0; i < nbr_form ; i++) {
        menu_class[i].classList.remove("active")
    }
}

suivant.addEventListener("click",()=>{

    checkLength(nomMenu , 3 , 30)
    checkLength(DescriptionMenu , 50 , 255)
    checkRequired([Burger])
    imageValidation(Image)

    if (imageValidation(Image)){
        etape++
        if (etape >= nbr_form){
            etape = 0
        }
        enleveclass()
        menu_class[etape].classList.add("active")

        if (etape == 2){
            document.getElementById("valider").style.visibility="visible"
            suivant.style.visibility="hidden"
            document.getElementById("suivant-class").classList.add("flex-row-reverse")
        }

        if (etape > 0){
            precedent.style.display="block"
        }
    }
})
precedent.addEventListener("click",()=>{
    etape--
    if (etape < 0){
        etape = nbr_form - 1
    }

    enleveclass()
    menu_class[etape].classList.add("active")
    if (etape == 0){
        precedent.style.display="none"
    }
    if (etape != 2){
        document.getElementById("valider").style.visibility="hidden"
        suivant.style.visibility="visible"
        document.getElementById("suivant-class").classList.remove("flex-row-reverse")
    }
})
