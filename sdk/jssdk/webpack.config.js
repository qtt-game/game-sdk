const path = require('path');
const package = require('./package.json');
const rules = require('./webpack.rules.js');

const config = {
    entry: path.resolve('./src/index.js'),
    output: {
        path: path.resolve('./dist'),
        publicPath: '/dist/',
        filename: `jssdk-${package.version}.js`,
        library: 'QTTGame',
        libraryTarget: 'umd',
    },
    externals: {
    },
    module: {
        rules,
    },
    plugins: [
    ],
    devtool: 'source-map',
};

module.exports = config;
