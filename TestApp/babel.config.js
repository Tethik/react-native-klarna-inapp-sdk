module.exports = {
  presets: ['module:metro-react-native-babel-preset'],
  env: {
    test: {
      presets: ['react-native', ['@babel/preset-env']],
    },
  },
};
