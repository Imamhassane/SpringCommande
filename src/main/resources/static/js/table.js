const showTable =  document.getElementsByClassName("showTable")
const table =  document.getElementsByClassName("table-content2")

const  burger  = document.getElementById("burger")
const  menuTab  = document.getElementById("menu")
const  complement  = document.getElementById("complement")


function enleveclass(tab) {
    for (let i = 0; i < tab.length ; i++) {
        tab[i].classList.remove("active")
    }
}
for (let i = 0; i < showTable.length ; i++) {
    showTable[i].addEventListener("click", ()=>{
        enleveclass(showTable)
        showTable[i].classList.add("active")

        let value =showTable[i].getAttribute("value")
        enleveclass(table)
        if(value == "burger"){
            burger.classList.add("active")
        } else if(value == "menu"){
            menuTab.classList.add("active")

        }else if(value == "comp"){
            complement.classList.add("active")
        }
    })
}