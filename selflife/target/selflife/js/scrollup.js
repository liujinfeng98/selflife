	  (function ($) {
                $.getQuery = function (query) {
                    query = query.replace(/[\[]/, '\\\[').replace(/[\]]/, '\\\]');
                    var expr = '[\\?&]' + query + '=([^&#]*)';
                    var regex = new RegExp(expr);
                    var results = regex.exec(window.location.href);
                    if (results !== null) {
                        return results[1];
                    } else {
                        return false;
                    }
                };
				 $.scrollUp({
                            animation: 'fade',
                           // activeOverlay: '#00FFFF',
                            scrollImg: {
                                active: true,
                                type: 'background',
                                src: '../Images/toTop1.png'
                            }
                        });
            })(jQuery);