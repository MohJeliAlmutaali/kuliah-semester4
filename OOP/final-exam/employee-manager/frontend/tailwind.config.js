/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/**/*.{js,jsx,ts,tsx}",
  ],
  theme: {
    extend: {
      boxShadow: {
        'neo-light': '8px 8px 16px #d1d9e6, -8px -8px 16px #ffffff',
        'neo-dark': 'inset 8px 8px 16px #d1d9e6, inset -8px -8px 16px #ffffff',
      },
      colors: {
        'background': '#e0e5ec',
      },
    },
  },

  variants: {},
  plugins: [
    require('daisyui'),
  ],
}