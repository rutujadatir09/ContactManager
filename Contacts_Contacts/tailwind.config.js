/** @type {import('tailwindcss').Config} */
export default {
  content: ["./src/main/resources/**/*.{html,js}"], // ✅ corrected path
  theme: {
    extend: {},
  },
  plugins: [],
  darkMode: "class", // ✅ correct key and value
};
