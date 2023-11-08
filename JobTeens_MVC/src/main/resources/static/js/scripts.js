// Fuction add/remove class active Lists
$(".offcanvas ul li").on('click', function() {
	$(".offcanvas ul li.active").removeClass('active');
	$(this).addClass('active');
})

// Fuction menu toggler
$(document).ready(function() {
	$(".togglerList").click(function() {
		// Fecha todas as outras ul que não estão dentro da li clicada
		$(".togglerList").not(this).find(".optionsList").hide();
		// Abre ou fecha a ul da li clicada
		$(this).find(".optionsList").toggle();
	});
});

// Fuction open/close offcanvas
 var canvas = document.getElementById("offcanvasScrolling");

  function handleOffcanvas() {
    if (window.innerWidth >= 950) { 
     canvas.classList.add("show");
    } else {
      canvas.classList.remove("show");
    }
  }

  window.addEventListener("load", handleOffcanvas);
  window.addEventListener("resize", handleOffcanvas);