var express = require('express');
var SerialPort = require('serialport');
var port = new SerialPort('/dev/ttyUSB0', {
    baudRate: 9600
}, false);
var router = express.Router();

router.get('/home/:id', function(request, response) {
    if(request.params.id == 'onledone'){
        port.write("1", function(err) {
            if(err) {
                response.send({
                    error: true,
                    message: err.message
                });
            }
            response.send({
                connection: [
                    {
                        connection: true
                    }
                ]
            });
        });
    
        port.on('error', function(err) {
            response.send({
                error: true,
                message: err.message
            });
        });
    } else if(request.params.id == 'offledone') {
        port.write("-1", function(err) {
            if(err) {
                response.send({
                    error: true,
                    message: err.message
                });
            }
            response.send({
                connection: [
                    {
                        connection: false
                    }
                ]
            });
        });
    
        port.on('error', function(err) {
            response.send({
                error: true,
                message: err.message
            });
        });
    } else if (request.params.id == 'onledtwo') {
        port.write("2", function(err) {
            if(err) {
                response.send({
                    error: true,
                    message: err.message
                });
            }
            response.send({
                connection: [
                    {
                        connection: true
                    }
                ]
            });
        });
    
        port.on('error', function(err) {
            response.send({
                error: true,
                message: err.message
            });
        });
    } else if (request.params.id == 'offledtwo') {
        port.write("-2", function(err) {
            if(err) {
                response.send({
                    error: true,
                    message: err.message
                });
            }
            response.send({
                connection: [
                    {
                        connection: false
                    }
                ]
            });
        });
    
        port.on('error', function(err) {
            response.send({
                error: true,
                message: err.message
            });
        });
    } else if (request.params.id == 'onledthree') {
        port.write("3", function(err) {
            if(err) {
                response.send({
                    error: true,
                    message: err.message
                });
            }
            response.send({
                connection: [
                    {
                        connection: true
                    }
                ]
            });
        });
    
        port.on('error', function(err) {
            response.send({
                error: true,
                message: err.message
            });
        });
    } else if (request.params.id == 'offledthree') {
        port.write("-3", function(err) {
            if(err) {
                response.send({
                    error: true,
                    message: err.message
                });
            }
            response.send({
                connection: [
                    {
                        connection: false
                    }
                ]
            });
        });
    
        port.on('error', function(err) {
            response.send({
                error: true,
                message: err.message
            });
        });
    }
});

module.exports = router;