// build.js — runs during Vercel deployment
// Reads ADMIN_PASSWORD from environment and injects it into admin/index.html

const fs = require("fs");
const path = require("path");

const password = process.env.ADMIN_PASSWORD;

if (!password) {
  console.error("❌ ERROR: ADMIN_PASSWORD environment variable is not set.");
  console.error(
    "   Go to Vercel Dashboard → Your Project → Settings → Environment Variables",
  );
  console.error("   Add: ADMIN_PASSWORD = your chosen password");
  process.exit(1);
}

const adminPath = path.join(__dirname, "admin", "index.html");
let html = fs.readFileSync(adminPath, "utf8");

if (!html.includes("%%ADMIN_PASSWORD%%")) {
  console.error(
    "❌ ERROR: Placeholder %%ADMIN_PASSWORD%% not found in admin/index.html",
  );
  process.exit(1);
}

html = html.replace("%%ADMIN_PASSWORD%%", password);
fs.writeFileSync(adminPath, html, "utf8");

console.log("✅ Admin password injected successfully.");
