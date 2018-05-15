var express = require('express');
var router = express.Router();

router.get('/test', function(request, response) {
    response.send({
        connection: [
            {
                connection: true
            }
        ]
    });
});

module.exports = router;