import sass from 'sass-embedded';
import fs from 'fs';
import path from 'path';
import { fileURLToPath } from 'url';

const __dirname = path.dirname(fileURLToPath(import.meta.url));

const inputFile = path.join(__dirname, 'src/tabulator/scss/tabulator.scss');
const outputFile = path.join(__dirname, 'dist/tabulator.css');

// Ensure dist directory exists
const distDir = path.dirname(outputFile);
if (!fs.existsSync(distDir)) {
  fs.mkdirSync(distDir, { recursive: true });
}

// Compile SCSS to CSS
try {
  const result = sass.compile(inputFile, {
    style: 'compressed',
    sourceMap: false,
  });

  fs.writeFileSync(outputFile, result.css);
  console.log(`✓ Successfully compiled Tabulator SCSS to ${outputFile}`);
  console.log(`  File size: ${(fs.statSync(outputFile).size / 1024).toFixed(2)} KB`);
} catch (error) {
  console.error('✗ Error compiling SCSS:', error.message);
  process.exit(1);
}

