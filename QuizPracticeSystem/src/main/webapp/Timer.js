var timer = 1200;

var interval = setInterval(() => {
  timer--;
  $(".timer").text(new Date(timer * 1000).toISOString().substr(11, 8));
  4;
  if (timer === 0) clearInterval(interval);
}, 2000);
