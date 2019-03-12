const baseConfig = require('./webpack.config.js');
const UglifyJsPlugin = require('uglifyjs-webpack-plugin');

const config = Object.assign({}, baseConfig, {
    plugins: [
        // new UglifyJsPlugin()
    ],
    devtool: 'source-map',
});

module.exports = config;
