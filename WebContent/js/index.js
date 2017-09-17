/**
 * 
 */
 var $j = jQuery.noConflict();
$j(".remove").click(function(){
  $.post("PlayerEdit",
  { 
	  PlayerId:${Player.PlayerId};
  },
  function(){
    alert("Ran");
  });
});