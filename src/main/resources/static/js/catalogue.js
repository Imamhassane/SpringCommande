let menu = document.querySelector('#menu-bars');
let navbar = document.querySelector('.navbar');
const menuContent= document.getElementById("menuContent")
const burgerContent= document.getElementById("burgerContent")
const burgerbutton= document.getElementById("burgerbutton")
const menubutton = document.getElementById("menubutton")


menu.onclick = () =>{
  menu.classList.toggle('fa-times');
  navbar.classList.toggle('active');
}


var swiper = new Swiper(".home-slider", {
  spaceBetween: 30,
  centeredSlides: true,
  autoplay: {
    delay: 7500,
    disableOnInteraction: false,
  },
  pagination: {
    el: ".swiper-pagination",
    clickable: true,
  },
  loop:true,
});

var swiper = new Swiper(".review-slider", {
  spaceBetween: 20,
  centeredSlides: true,
  autoplay: {
    delay: 7500,
    disableOnInteraction: false,
  },
  loop:true,
  breakpoints: {
    0: {
        slidesPerView: 1,
    },
    640: {
      slidesPerView: 2,
    },
    768: {
      slidesPerView: 2,
    },
    1024: {
      slidesPerView: 3,
    },
  },
});

burgerbutton.addEventListener("click",()=>{
  burgerContent.style.display = "grid"
  menuContent.style.display="none"
  burgerbutton.classList.add("active")
  menubutton.classList.remove("active")
})
menubutton.addEventListener("click",()=>{
  burgerContent.style.display = "none"
  menuContent.style.display="grid"
  menubutton.classList.add("active")
  burgerbutton.classList.remove("active")
})